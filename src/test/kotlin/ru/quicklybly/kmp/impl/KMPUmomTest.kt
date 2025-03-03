package ru.quicklybly.kmp.impl

import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

internal class KMPUmomTest : AbstractKMPTest() {
    override val kmp = KMPUmom(LinearPrefixFunction())
}
