package ru.quicklybly.prefixfunction

fun List<Int>.toModifiedPrefixFunction(): List<Int> {
    val n = this.size
    val result = MutableList(n) { 0 }
    result[n - 1] = this[n - 1]

    for (i in 1 until n - 1) {
        result[i] = if (this[i] != 0 && this[i] + 1 == this[i + 1]) {
            result[this[i] - 1]
        } else {
            this[i]
        }
    }
    return result
}
