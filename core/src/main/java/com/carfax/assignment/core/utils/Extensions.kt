package com.carfax.assignment.core.utils

fun Int.formatDecimalSeparator(): String {
    return toString()
        .reversed()
        .chunked(3)
        .joinToString(",")
        .reversed()
}

fun Int.formatNumberShortcut(): String {
    if (this < 1000)
        return "" + this
    val exp = (Math.log(this.toDouble()) / Math.log(1000.0)).toInt()
    return String.format("%.1f %c", this / Math.pow(1000.0, exp.toDouble()), "kM"[exp - 1])
}
