package ru.quicklybly.kmp.impl

import ru.quicklybly.AbstractFindAllOccurrencesTest
import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

class KMPPTest : AbstractFindAllOccurrencesTest() {
    override val findAllOccurrences = KMPP(LinearPrefixFunction())
}
