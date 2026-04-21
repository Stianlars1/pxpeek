package dev.stianl.pxpeek

import com.intellij.codeInsight.hints.declarative.HintFormat
import com.intellij.codeInsight.hints.declarative.InlayHintsCollector
import com.intellij.codeInsight.hints.declarative.InlayHintsProvider
import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.declarative.InlineInlayPosition
import com.intellij.codeInsight.hints.declarative.OwnBypassCollector
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil
import dev.stianl.pxpeek.feedback.RatePromptService

private val SIZE_REGEX = Regex(
    "^(-?\\d+(?:\\.\\d+)?)(rem|em|pt|pc|in|cm|mm|q|ch|ex|vmin|vmax|svw|lvw|dvw|svh|lvh|dvh|vw|vh|%)$",
    RegexOption.IGNORE_CASE,
)

class CssSizeInlayProvider : InlayHintsProvider {
    override fun createCollector(file: PsiFile, editor: Editor): InlayHintsCollector {
        return FileCollector(editor)
    }

    private class FileCollector(private val editor: Editor) : OwnBypassCollector {
        override fun collectHintsForFile(file: PsiFile, sink: InlayTreeSink) {
            val settings = PxPeekSettings.getInstance()
            val placement = settings.placement
            val showPercent = settings.showPercent
            val hits = mutableListOf<Hit>()

            PsiTreeUtil.processElements(file) { element ->
                matchElement(element, showPercent)?.let { hits.add(it) }
                true
            }

            if (hits.isEmpty()) return

            RatePromptService.getInstance().recordUsage()

            when (placement) {
                HintPlacement.INLINE -> emitInline(hits, sink)
                HintPlacement.END_OF_LINE -> emitEndOfLine(hits, sink)
            }
        }

        private fun matchElement(element: PsiElement, showPercent: Boolean): Hit? {
            val text = element.text ?: return null
            if (text.length < 2 || text.length > 32) return null

            val onlyChild = element.firstChild?.takeIf { it.nextSibling == null }
            if (onlyChild != null && onlyChild.textRange == element.textRange) return null

            val match = SIZE_REGEX.matchEntire(text) ?: return null
            val value = match.groupValues[1].toDoubleOrNull() ?: return null
            if (value == 0.0) return null

            val unit = match.groupValues[2]
            if (unit == "%" && !showPercent) return null
            val px = UnitConverter.toPixels(value, unit) ?: return null

            return Hit(
                offset = element.textRange.endOffset,
                line = editor.document.getLineNumber(element.textRange.startOffset),
                formatted = UnitConverter.format(px),
            )
        }

        private fun emitInline(hits: List<Hit>, sink: InlayTreeSink) {
            for (hit in hits) {
                sink.addPresentation(
                    position = InlineInlayPosition(hit.offset, relatedToPrevious = true),
                    hintFormat = HintFormat.default,
                ) {
                    text("/* ${hit.formatted}px */")
                }
            }
        }

        private fun emitEndOfLine(hits: List<Hit>, sink: InlayTreeSink) {
            val doc = editor.document
            val grouped = hits.groupBy { it.line }

            for ((line, lineHits) in grouped) {
                val lineEndOffset = doc.getLineEndOffset(line)
                val aggregated = lineHits.joinToString(", ") { "${it.formatted}px" }

                sink.addPresentation(
                    position = InlineInlayPosition(lineEndOffset, relatedToPrevious = true),
                    hintFormat = HintFormat.default,
                ) {
                    text("/* $aggregated */")
                }
            }
        }
    }

    private data class Hit(val offset: Int, val line: Int, val formatted: String)
}
