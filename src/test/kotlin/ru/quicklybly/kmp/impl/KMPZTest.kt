package ru.quicklybly.kmp.impl

import ru.quicklybly.AbstractFindAllOccurrencesTest
import ru.quicklybly.kmp.KMP
import ru.quicklybly.zfunction.impl.LinearZFunction

class KMPZTest : AbstractFindAllOccurrencesTest() {
    override val findAllOccurrences: KMP = KMPZ(LinearZFunction())
}
