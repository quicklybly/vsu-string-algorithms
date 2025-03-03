package ru.quicklybly.kmp.impl

import org.assertj.core.api.Assertions.assertThat
import ru.quicklybly.kmp.KMP
import kotlin.test.Test

abstract class AbstractKMPTest {
    protected abstract val kmp: KMP

    @Test
    fun findAllOccurrences() {
        val string = "aabaacaadaabaaba"
        val pattern = "aaba"
        val expected = listOf(0, 9, 12)

        val result = kmp.findAllOccurrences(string, pattern)
        assertThat(result).containsExactlyElementsOf(expected)
    }
}