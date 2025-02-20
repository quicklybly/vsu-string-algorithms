package ru.quicklybly.prefixfunction.impl

import ru.quicklybly.prefixfunction.PrefixFunction

class LinearPrefixFunction : PrefixFunction {
    override fun prefixFunction(s: String): List<Int> {
        val n = s.length
        val result = MutableList(n) { 0 }

        for (i in 1 until n) {
            var bpRight = result[i - 1]
            while (bpRight > 0 && s[i] != s[bpRight]) {
                bpRight = result[bpRight - 1]
            }
            result[i] = if (s[i] == s[bpRight]) {
                bpRight + 1
            } else {
                0
            }
        }
        return result
    }
}
