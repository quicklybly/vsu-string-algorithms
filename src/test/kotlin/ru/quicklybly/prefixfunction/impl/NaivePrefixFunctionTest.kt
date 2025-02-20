package ru.quicklybly.prefixfunction.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.quicklybly.prefixfunction.PrefixFunction

class NaivePrefixFunctionTest {
    private val prefixFunction: PrefixFunction = NaivePrefixFunction()

    @Test
    fun prefixFunction() {
        val s = "ABAABABAABAABC"
        val expected = listOf(0, 0, 1, 1, 2, 3, 2, 3, 4, 5, 6, 4, 5, 0)
        val result = prefixFunction.prefixFunction(s)

        assertThat(result).containsExactlyElementsOf(expected)
    }
}
