package ru.quicklybly.zfunction.impl

import ru.quicklybly.zfunction.ZFunction
import kotlin.math.max
import kotlin.math.min

class LinearZFunction : ZFunction {
    override fun zFunction(s: String): List<Int> {
        val n = s.length
        var l = 0
        val z = MutableList(n) { 0 }

        for (i in 1 until n) {
            z[i] = max(
                min(z[i - l], l + z[l] - i),
                0, // empty l case
            )
            while (i + z[i] < n && s[z[i]] == s[z[i] + i]) {
                z[i]++
            }
            if (z[i] + i > z[l] + l) {
                l = i
            }
        }
        return z
    }
}
