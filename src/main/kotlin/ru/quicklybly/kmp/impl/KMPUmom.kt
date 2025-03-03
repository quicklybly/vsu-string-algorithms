package ru.quicklybly.kmp.impl

import ru.quicklybly.kmp.KMP
import ru.quicklybly.prefixfunction.PrefixFunction
import ru.quicklybly.prefixfunction.toModifiedPrefixFunction

class KMPUmom(private val prefixFunction: PrefixFunction) : KMP {
    override fun findAllOccurrences(string: String, pattern: String): List<Int> {
        val prefixFunctionForPattern = prefixFunction.prefixFunction(pattern)
        val modifiedPrefixFunctionForPattern = prefixFunctionForPattern.toModifiedPrefixFunction()

        val n = string.length
        val m = pattern.length
        val result = mutableListOf<Int>()
        var i = 0
        var j = 0
        while (i < n) {
            if (string[i] == pattern[j]) {
                if (j == m - 1) {
                    result.add(i - m + 1)
                    j = modifiedPrefixFunctionForPattern[j - 1]
                } else {
                    i++
                    j++
                }
            } else {
                if (j == 0) i++ else j = modifiedPrefixFunctionForPattern[j - 1]
            }
        }
        return result
    }
}
