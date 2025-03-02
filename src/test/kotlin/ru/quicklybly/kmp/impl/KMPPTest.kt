package ru.quicklybly.kmp.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.quicklybly.kmp.KMP
import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

class KMPPTest {
    private val prefixFunction = LinearPrefixFunction()
    private val kmp: KMP = KMPP(prefixFunction)

    @Test
    fun findAllOccurrences() {
        val string = "aabaacaadaabaaba"
        val pattern = "aaba"
        val expected = listOf(0, 9, 12)

        val result = kmp.findAllOccurrences(string, pattern)
        assertThat(result).containsExactlyElementsOf(expected)
    }
}
