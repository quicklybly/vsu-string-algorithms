package ru.quicklybly.bm

import ru.quicklybly.FindAllOccurrences
import ru.quicklybly.zfunction.ZFunction

class BoyerMoore(private val zFunction: ZFunction) : FindAllOccurrences {

    override fun findAllOccurrences(string: String, pattern: String): List<Int> {
        if (pattern.isEmpty()) return emptyList()

        val badCharMap = buildBadCharMap(pattern)
        val goodSuffixShift = buildGoodSuffixShift(pattern)
        val result = mutableListOf<Int>()

        val n = string.length
        val m = pattern.length

        var patternShift = 0
        while (patternShift <= n - m) {
            var j = m - 1

            while (j >= 0 && pattern[j] == string[patternShift + j]) {
                j--
            }

            if (j < 0) {
                result.add(patternShift)
                patternShift += 1
            } else {
                patternShift += maxOf(badCharMap[string[patternShift + j]]!!, goodSuffixShift[j])
            }
        }

        return result
    }

    /**
     * Time Complexity - O(m)
     * @return map character to shift
     */
    private fun buildBadCharMap(pattern: String): Map<Char, Int> {
        val m = pattern.length
        val result = mutableMapOf<Char, Int>()
        for (c in 'a'..'z') {
            result[c] = m
        }
        for (i in 0 until m - 1) {
            result[pattern[i]] = m - i - 1
        }
        return result
    }

    private fun buildGoodSuffixShift(pattern: String): List<Int> {
        val m = pattern.length
        val result = MutableList(m) { m }

        val z: List<Int> = zFunction.zFunction(pattern.reversed())

        val zReversed = IntArray(m)
        for (i in z.indices) {
            if (z[i] > 0) {
                zReversed[m - z[i]] = i + 1
            }
        }

        for (i in m - 1 downTo 0) {
            if (z[i] == i + 1) {
                for (j in 0 until m - 1 - i) {
                    if (result[j] == m) {
                        result[j] = m - 1 - i
                    }
                }
            }
        }

        for (i in 0 until m - 1) {
            result[m - 1 - z[i]] = m - 1 - i
        }

        return result
    }
}
