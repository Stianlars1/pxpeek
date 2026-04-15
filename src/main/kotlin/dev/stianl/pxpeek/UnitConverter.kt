package dev.stianl.pxpeek

private const val ROOT_FONT_PX = 16.0
private const val VIEWPORT_W = 1440.0
private const val VIEWPORT_H = 900.0

object UnitConverter {
    fun toPixels(value: Double, unit: String): Double? = when (unit.lowercase()) {
        "rem", "em" -> value * ROOT_FONT_PX
        "%"         -> value * ROOT_FONT_PX / 100.0
        "pt"        -> value * 96.0 / 72.0
        "pc"        -> value * 16.0
        "in"        -> value * 96.0
        "cm"        -> value * 37.7952755906
        "mm"        -> value * 3.77952755906
        "q"         -> value * 0.94488188976
        "ch"        -> value * 8.0
        "ex"        -> value * 8.0
        "vw", "svw", "lvw", "dvw" -> value * VIEWPORT_W / 100.0
        "vh", "svh", "lvh", "dvh" -> value * VIEWPORT_H / 100.0
        "vmin"      -> value * minOf(VIEWPORT_W, VIEWPORT_H) / 100.0
        "vmax"      -> value * maxOf(VIEWPORT_W, VIEWPORT_H) / 100.0
        else -> null
    }

    fun format(px: Double): String {
        val rounded = (px * 10.0).let { kotlin.math.round(it) } / 10.0
        return if (rounded == rounded.toLong().toDouble()) rounded.toLong().toString()
        else "%.1f".format(rounded)
    }
}
