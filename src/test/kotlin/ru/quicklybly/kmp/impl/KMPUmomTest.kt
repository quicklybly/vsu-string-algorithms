package ru.quicklybly.kmp.impl

import ru.quicklybly.AbstractFindAllOccurrencesTest
import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

internal class KMPUmomTest : AbstractFindAllOccurrencesTest() {
    override val findAllOccurrences = KMPUmom(LinearPrefixFunction())
}
