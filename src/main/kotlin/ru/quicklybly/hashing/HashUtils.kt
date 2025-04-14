package ru.quicklybly.hashing

private const val X = 31
private const val MODULE: Int = 9973

fun buildPrefixHashArray(string: String): List<Int> {
    val result = MutableList(string.length) { 0 }
    result[0] = string[0].code
    for (i in 1 until string.length) {
        result[i] = ((result[i - 1] * X % MODULE) + string[i].code) % MODULE
    }

    return result
}

fun List<Int>.hash(l: Int, r: Int): Int {
    require(l >= 0 && r < size && l <= r) { "Invalid input" }

    return if (l == 0) {
        this[r]
    } else {
        (this[r] - (this[l - 1] * (X binPow r - l + 1)) % MODULE + MODULE) % MODULE
    }
}

infix fun Int.binPow(n: Int): Int {
    var result = 1
    var base = this % MODULE
    var exponent = n

    while (exponent > 0) {
        if ((exponent and 1) == 1) {
            result = (result * base) % MODULE
        }
        base = (base * base) % MODULE
        exponent = exponent shr 1
    }

    return result
}
