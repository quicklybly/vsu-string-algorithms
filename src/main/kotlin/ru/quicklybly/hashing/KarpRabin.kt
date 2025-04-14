package ru.quicklybly.hashing

import ru.quicklybly.FindAllOccurrences
import ru.quicklybly.utils.compareSubstring

class KarpRabin : FindAllOccurrences {
    override fun findAllOccurrences(string: String, pattern: String): List<Int> {
        val n = string.length
        val m = pattern.length

        val patternHash = buildPrefixHashArray(pattern).hash(0, m - 1)
        val hashArray = buildPrefixHashArray(string)

        val result = mutableListOf<Int>()
        for (i in 0..n - m) {
            if (patternHash == hashArray.hash(i, i + m - 1) && compareSubstring(string, pattern, i)) {
                result.add(i)
            }
        }

        return result
    }
}
