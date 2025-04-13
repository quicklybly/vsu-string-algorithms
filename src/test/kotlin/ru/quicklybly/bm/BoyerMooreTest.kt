package ru.quicklybly.bm

import ru.quicklybly.AbstractFindAllOccurrencesTest
import ru.quicklybly.zfunction.impl.LinearZFunction

class BoyerMooreTest : AbstractFindAllOccurrencesTest() {
    override val findAllOccurrences = BoyerMoore(LinearZFunction())
}
