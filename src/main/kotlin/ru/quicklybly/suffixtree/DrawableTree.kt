package ru.quicklybly.suffixtree

import java.io.File
import java.io.IOException

// thx chatgpt for this code
class DrawableSuffixTree(input: String) : SuffixTree(input) {

    fun generateDot(): String {
        val sb = StringBuilder()
        sb.append("digraph SuffixTree {\n")
        sb.append("    node [shape=circle];\n")

        fun traverse(node: Node, parentId: String? = null, edgeLabel: String? = null) {
            val nodeId = "node${System.identityHashCode(node)}"  // Уникальный идентификатор узла

            when (node) {
                virtualRoot -> sb.append("    $nodeId [label=\"Virtual Root\", shape=doublecircle, color=grey];\n")
                root -> sb.append("    $nodeId [label=\"Root\", shape=doublecircle, color=black];\n")
                else -> {
                    val substring = text.substring(node.start, node.end)
                    sb.append("    $nodeId [label=\"${node.start},${node.end}\\n'$substring'\"];\n")
                }
            }

            if (parentId != null && edgeLabel != null) {
                sb.append("    $parentId -> $nodeId [label=\"$edgeLabel\"];\n")
            }

            for ((ch, child) in node.children) {
                traverse(child, nodeId, ch.toString())
            }

            node.suffixLink?.let { (suffixNode, _) ->
                val suffixNodeId = "node${System.identityHashCode(suffixNode)}"
                sb.append("    $nodeId -> $suffixNodeId [style=dashed, color=blue, label=\"slink\"];\n")
            }
        }

        traverse(root, "node${System.identityHashCode(virtualRoot)}", "virtual")

        sb.append("}\n")
        return sb.toString()
    }

    fun saveDotToFile(filename: String) {
        val dot = generateDot()
        File(filename).writeText(dot)
        println("DOT файл сохранен как $filename")
    }

    fun renderGraph(outputFormat: String = "png", outputFile: String = "suffix_tree.$outputFormat") {
        val dotFilename = "temp_suffix_tree.dot"
        saveDotToFile(dotFilename)

        try {
            val process = ProcessBuilder("dot", "-T$outputFormat", dotFilename, "-o", outputFile)
                .redirectErrorStream(true)
                .start()

            val exitCode = process.waitFor()
            if (exitCode == 0) {
                println("Граф успешно отрендерен и сохранен как $outputFile")
                File(dotFilename).delete()
            } else {
                println("Ошибка при рендеринге графа. Код выхода: $exitCode")
                val output = process.inputStream.bufferedReader().use { it.readText() }
                println(output)
            }
        } catch (e: IOException) {
            println("Ошибка при попытке вызвать Graphviz. Убедитесь, что Graphviz установлен и добавлен в PATH.")
            e.printStackTrace()
        } catch (e: InterruptedException) {
            println("Процесс рендеринга был прерван.")
            e.printStackTrace()
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val input = "abracadabra"
            val drawableTree = DrawableSuffixTree(input)

            drawableTree.saveDotToFile("suffix_tree.dot")

            drawableTree.renderGraph(outputFormat = "png", outputFile = "suffix_tree.png")
        }
    }
}
