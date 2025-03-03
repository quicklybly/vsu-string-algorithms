package ru.quicklybly.prefixfunction

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class UtilsKtTest {

    @Test
    fun test() {
        val input = listOf(0, 0, 0, 1, 2, 0, 0, 1, 2, 3, 4, 5, 6)
        val expected = listOf(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 6)

        assertThat(input.toModifiedPrefixFunction()).isEqualTo(expected)
    }
}
