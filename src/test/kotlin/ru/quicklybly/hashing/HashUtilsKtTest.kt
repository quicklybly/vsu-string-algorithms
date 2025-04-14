package ru.quicklybly.hashing

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class HashUtilsKtTest {

    @Test
    fun binPow() {
        assertThat(2 binPow 3).isEqualTo(8)
    }
}
