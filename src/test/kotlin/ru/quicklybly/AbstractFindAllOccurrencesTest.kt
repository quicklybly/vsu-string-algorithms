package ru.quicklybly

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

abstract class AbstractFindAllOccurrencesTest {
    protected abstract val findAllOccurrences: FindAllOccurrences

    @Test
    fun findAllOccurrences() {
        val string = "aabaacaadaabaaba"
        val pattern = "aaba"
        val expected = listOf(0, 9, 12)

        val result = findAllOccurrences.findAllOccurrences(string, pattern)
        assertThat(result).containsExactlyElementsOf(expected)
    }
}