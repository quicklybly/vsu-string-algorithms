package ru.quicklybly.kmp.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.quicklybly.kmp.KMP
import ru.quicklybly.zfunction.impl.LinearZFunction

class KMPZTest {
    private val zFunction = LinearZFunction()
    private val kmp: KMP = KMPZ(zFunction)

    @Test
    fun findAllOccurrences() {
        val string = "aabaacaadaabaaba"
        val pattern = "aaba"
        val expected = listOf(0, 9, 12)

        val result = kmp.findAllOccurrences(string, pattern)
        assertThat(result).containsExactlyElementsOf(expected)
    }
}
