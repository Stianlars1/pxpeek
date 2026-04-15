package dev.stianl.pxpeek

import com.intellij.codeInsight.hints.declarative.HintFormat
import com.intellij.codeInsight.hints.declarative.InlayHintsCollector
import com.intellij.codeInsight.hints.declarative.InlayHintsProvider
import com.intellij.codeInsight.hints.declarative.InlayTreeSink
import com.intellij.codeInsight.hints.declarative.InlineInlayPosition
import com.intellij.codeInsight.hints.declarative.SharedBypassCollector
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

private val SIZE_REGEX = Regex(
    "^(-?\\d+(?:\\.\\d+)?)(rem|em|pt|pc|in|cm|mm|q|ch|ex|vmin|vmax|svw|lvw|dvw|svh|lvh|dvh|vw|vh|%)$",
    RegexOption.IGNORE_CASE,
)

class CssSizeInlayProvider : InlayHintsProvider {
    override fun createCollector(file: PsiFile, editor: Editor): InlayHintsCollector = Collector

    private object Collector : SharedBypassCollector {
        override fun collectFromElement(element: PsiElement, sink: InlayTreeSink) {
            val text = element.text ?: return
            if (text.length < 2 || text.length > 32) return
            // Skip single-child wrappers covering the same range — emit only on the
            // innermost element (CSS PSI nests e.g. CssTermList > CssTerm > CssNumberTerm).
            val onlyChild = element.firstChild?.takeIf { it.nextSibling == null }
            if (onlyChild != null && onlyChild.textRange == element.textRange) return

            val match = SIZE_REGEX.matchEntire(text) ?: return
            val value = match.groupValues[1].toDoubleOrNull() ?: return
            if (value == 0.0) return

            val unit = match.groupValues[2]
            val px = UnitConverter.toPixels(value, unit) ?: return

            val formatted = UnitConverter.format(px)
            val endOffset = element.textRange.endOffset

            sink.addPresentation(
                position = InlineInlayPosition(endOffset, relatedToPrevious = true),
                hintFormat = HintFormat.default,
            ) {
                text("/* ${formatted}px */")
            }
        }
    }
}
