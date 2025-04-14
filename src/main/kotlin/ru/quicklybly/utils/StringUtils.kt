package ru.quicklybly.utils

fun compareSubstring(mainString: String, subString: String, startIndex: Int): Boolean {
    if (startIndex + subString.length > mainString.length) {
        return false
    }

    for (i in subString.indices) {
        if (mainString[startIndex + i] != subString[i]) {
            return false
        }
    }

    return true
}
