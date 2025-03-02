package ru.quicklybly.kmp.impl

import ru.quicklybly.kmp.KMP
import ru.quicklybly.prefixfunction.PrefixFunction

class KMPP(private val prefixFunction: PrefixFunction) : KMP {

    override fun findAllOccurrences(string: String, pattern: String): List<Int> {
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
