package ru.quicklybly.kmp

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

class KMPTest {
    private val prefixFunction = LinearPrefixFunction()
    private val kmp = KMP(prefixFunction)

    @Test
    fun findAllOccurrences() {
        val string = "aabaacaadaabaaba"
        val pattern = "aaba"
        val expected = listOf(0, 9, 12)

        val result = kmp.findAllOccurrences(string, pattern)
        assertThat(result).containsExactlyElementsOf(expected)
    }
}
