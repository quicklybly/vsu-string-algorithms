package ru.quicklybly.kmp.impl

import ru.quicklybly.prefixfunction.impl.LinearPrefixFunction

class KMPPTest : AbstractKMPTest() {
    override val kmp = KMPP(LinearPrefixFunction())
}
