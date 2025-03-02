package ru.quicklybly.zfunction.impl

import ru.quicklybly.zfunction.ZFunction

class NaiveZFunction : ZFunction {
    override fun zFunction(s: String): List<Int> {
        val n = s.length
        val z = MutableList(n) { 0 }

        for (i in 1 until n) {
            var j = i
            while (j < n && s[j] == s[j - i]) {
                j++
                z[i] = j - i
            }
        }
        return z
    }
}
