package ru.quicklybly.prefixfunction.impl

import ru.quicklybly.prefixfunction.PrefixFunction

class NaivePrefixFunction : PrefixFunction {
    override fun prefixFunction(s: String): List<Int> {
        val n = s.length
        val result = MutableList(n) { 0 }

        for (i in 0 until n) {
            for (j in 1..i) {
                if (isPrefixAndSuffixEquals(s, i, j)) {
                    result[i] = j
                }
            }
        }
        return result
    }

    private fun isPrefixAndSuffixEquals(string: String, endIndex: Int, size: Int): Boolean {
        if (endIndex == size) return false
        for (i in 0 until size) {
            if (string[i] != string[endIndex - size + 1 + i]) {
                return false
            }
        }
        return true
    }
}
