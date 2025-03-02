package ru.quicklybly.kmp

interface KMP {
    fun findAllOccurrences(string: String, pattern: String): List<Int>
}
