package ru.quicklybly.hashing

import ru.quicklybly.AbstractFindAllOccurrencesTest
import ru.quicklybly.FindAllOccurrences

class KarpRabinTest : AbstractFindAllOccurrencesTest() {
    override val findAllOccurrences: FindAllOccurrences = KarpRabin()
}
