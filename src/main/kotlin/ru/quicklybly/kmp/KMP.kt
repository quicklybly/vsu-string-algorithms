package ru.quicklybly.kmp

import ru.quicklybly.prefixfunction.PrefixFunction

class KMP(private val prefixFunction: PrefixFunction) {

    fun findAllOccurrences(string: String, pattern: String): List<Int> {
        val borderArray = prefixFunction.prefixFunction("$pattern#$string")
        val result = mutableListOf<Int>()
        borderArray.forEachIndexed { index, borderSize ->
            if (borderSize == pattern.length) {
                result.add(index - pattern.length * 2)
            }
        }
        return result
    }
}
