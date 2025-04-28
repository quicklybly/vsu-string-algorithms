package ru.quicklybly.suffixtree

data class Node(var start: Int, var end: Int, var parent: Node? = null) {
    val children: MutableMap<Char, Node> = mutableMapOf()
    var suffixLink: Pair<Node, Int>? = null
}

private class Position(val text: String, var node: Node, var index: Int?) {

    fun hasMove(char: Char): Boolean {
        if (index == null) {
            return true
        }
        val newIndex = index!! + 1
        val vertexCase = (newIndex) >= node.end && node.children.contains(char)
        val edgeCase = (newIndex) < node.end && char == text[newIndex]

        return vertexCase || edgeCase
    }

    fun move(char: Char) {
        if (index == null) {
            return
        }

        // on vertex itself
        if (index!! + 1 >= node.end) {
            node = node.children[char] ?: throw IllegalStateException("move was called, but no node found")
            index = node.start
        } else {
            // on the edge
            index = index!! + 1
        }
    }

    fun createNode(textIndex: Int) {
        val char = text[textIndex]
        val n = text.length

        // vertex
        val newIndex = index!! + 1
        if (newIndex >= node.end) {
            node.children[char] = Node(textIndex, n, node)
            return
        }

        // edge case
        val u = Node(node.start, newIndex, node.parent)
        val newChar = text[newIndex]
        u.children[newChar] = node

        val uch = text[u.start]
        node.parent?.children?.set(uch, u)

        // add suffix link
        var ancestor: Node? = u
        while (ancestor != null && ancestor.suffixLink == null) {
            ancestor = ancestor.parent // todo
        }
        var currentNode = if (ancestor?.suffixLink != null) {
            ancestor.suffixLink!!.first
        } else {
            node
        }
        var j = currentNode.start

        // go down
        for (k in u.start until u.end) {
            val uchk = text[k]

            if (j + 1 < currentNode.end) {
                if (text[j + 1] == uchk) {
                    j++
                }
            } else {
                if (currentNode.children.containsKey(uchk)) {
                    currentNode = currentNode.children[uchk]!!
                    j = currentNode.start
                }
            }
        }

        u.suffixLink = currentNode to j

        node.parent = u
        node.start = index!! + 1
        node = u

        node.children[char] = Node(textIndex, n, node)
    }

    fun goToSuffixLink() {
        index = node.suffixLink?.second
        node = node.suffixLink?.first ?: node
    }
}

open class SuffixTree(input: String) {

    protected val text: String = "$input$"
    protected val root: Node = Node(0, 0)
    protected val virtualRoot: Node = Node(-1, -1)
    private val currentPosition: Position

    init {
        for (c in 'a'..'z') {
            virtualRoot.children[c] = root
        }
        root.suffixLink = virtualRoot to virtualRoot.start

        currentPosition = Position(text, root, 0)

        // actually building the tree
        text.forEachIndexed { index, char ->
            while (currentPosition.hasMove(char).not()) {
                currentPosition.createNode(index)
                currentPosition.goToSuffixLink()
            }
            currentPosition.move(char)
        }
    }
}
