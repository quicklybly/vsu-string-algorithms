package ru.quicklybly.zfunction.impl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import ru.quicklybly.zfunction.ZFunction

class LinearZFunctionTest {
    private val function: ZFunction = LinearZFunction()

    @Test
    fun zFunction() {
        val s = "ABAABABAABAABC"
        val expected = listOf(0, 0, 1, 3, 0, 6, 0, 1, 5, 0, 1, 2, 0, 0)
        val result = function.zFunction(s)

        assertThat(result).containsExactlyElementsOf(expected)
    }
}