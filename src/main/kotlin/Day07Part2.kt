class Day07Part2 {
    fun solve(input: List<String>): Int {
        val treeNodesByName = input.map { parseNode(it) }.associateBy { it.name }

        treeNodesByName.forEach { _, parentNode ->
            parentNode.childNames.forEach {
                childName ->
                val childNode = treeNodesByName[childName]!!
                parentNode.childNodes.add(childNode)
                childNode.parentNode = parentNode
            }
        }
        val rootNode = treeNodesByName.entries.first { it.value.parentNode == null }.key


        return findNode(treeNodesByName[rootNode]!!, 0)

    }

    private fun findNode(node: TreeNode, difference: Int): Int {

        return if (node.isBalanced()) {
            node.weight - difference
        } else {

            val unbalancedTree = node.childNodes.groupBy { it.inherentWeight() }
                    .minBy { it.value.size }!!
                    .value
                    .first()

            val diff = node.childNodes
                    .groupBy { it.inherentWeight() }
                    .keys
                    .distinct()
                    .reduce { x, y -> Math.abs(x - y) }
            findNode(unbalancedTree, diff)
        }


    }

    private fun parseNode(line: String): TreeNode {
        val regex = Regex("""(.*) \((\d+)\)( -> (.*))?""")
        val matchResult = regex.matchEntire(line)
        return when (matchResult != null) {
            true -> {
                val name = matchResult!!.groups[1]!!.value
                val weight = Integer.valueOf(matchResult.groups[2]!!.value)
                val childNames = matchResult.groups[4]?.value

                val children = childNames?.split(""",\s+""".toRegex())?.toList()
                TreeNode(name, weight, children.orEmpty())
            }
            else -> throw Exception("Invalid line: $line")
        }
    }

    data class TreeNode(val name: String, val weight: Int, val childNames: List<String>,
                        val childNodes: MutableList<TreeNode> = mutableListOf(),
                        var parentNode: TreeNode? = null) {
        fun hasChildren(): Boolean = childNames.isNotEmpty()
        fun inherentWeight(): Int = weight + childNodes.map { it.inherentWeight() }.sum()
        fun isBalanced(): Boolean = childNodes.map { it.inherentWeight() }.distinct().size == 1
    }

}