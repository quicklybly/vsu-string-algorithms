package ru.quicklybly.kmp.impl

import ru.quicklybly.kmp.KMP
import ru.quicklybly.zfunction.impl.LinearZFunction

class KMPZTest : AbstractKMPTest() {
    override val kmp: KMP = KMPZ(LinearZFunction())
}
