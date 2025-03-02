package ru.quicklybly.kmp.impl

import ru.quicklybly.kmp.KMP
import ru.quicklybly.zfunction.ZFunction

class KMPZ(private val zFunction: ZFunction) : KMP {

    override fun findAllOccurrences(string: String, pattern: String): List<Int> {
        val z = zFunction.zFunction("$pattern#$string")
        val result = mutableListOf<Int>()
        for (i in pattern.length until pattern.length + string.length + 1) {
            if (z[i] == pattern.length) {
                result.add(i - pattern.length - 1)
            }
        }
        return result
    }
}
