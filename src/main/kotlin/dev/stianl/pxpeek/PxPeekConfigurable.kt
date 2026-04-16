package dev.stianl.pxpeek

import com.intellij.openapi.options.BoundConfigurable
import com.intellij.ui.dsl.builder.bind
import com.intellij.ui.dsl.builder.bindSelected
import com.intellij.ui.dsl.builder.panel

class PxPeekConfigurable : BoundConfigurable("PxPeek") {
    private val settings = PxPeekSettings.getInstance()

    override fun createPanel() = panel {
        group("Hint Placement") {
            buttonsGroup {
                row {
                    radioButton("Inline — next to each value", HintPlacement.INLINE)
                        .comment("width: 42rem <b>/* 672px */</b>, 100% <b>/* 16px */</b>)")
                }
                row {
                    radioButton("End of line — after the semicolon", HintPlacement.END_OF_LINE)
                        .comment("width: min(42rem, 100%); <b>/* 672px, 16px */</b>")
                }
            }.bind(settings::placement)
        }
        group("Units") {
            row {
                checkBox("Show hints for % values")
                    .comment("Off by default — % is context-dependent (parent width vs. font-size). The conversion assumes % of root font size (16px), which is only accurate for font-size.")
                    .bindSelected(settings::showPercent)
            }
        }
    }
}
