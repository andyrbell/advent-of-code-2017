class Day07Part2 {
    fun solve(input: List<String>): Int {
        val referenceCount = mutableMapOf<String, Int>()
        val register = input.map { parseNode(it, referenceCount) }.associateBy { it.name }

        val rootNode = referenceCount.entries.first { it.value == 1 }.key

        val calculatedWeight = calculateWeight(register[rootNode]!!, register)
        println("rootNode weight: $calculatedWeight")

        fun findNode(name: String): TreeNode {
            return register[name]!!
        }

        return 0
    }

    private fun parseNode(line: String, referenceCount: MutableMap<String, Int>): TreeNode {
        val regex = Regex("""(.*) \((\d+)\)( -> (.*))?""")
        val matchResult = regex.matchEntire(line)
        return when (matchResult != null) {
            true -> {
                val name = matchResult!!.groups[1]!!.value
                val weight = Integer.valueOf(matchResult.groups[2]!!.value)
                val childNames = matchResult.groups[4]?.value
                referenceCount.put(name, referenceCount.getOrDefault(name, 0) + 1)

                val children = childNames?.split(""",\s+""".toRegex())?.toList()
                children?.forEach {
                    referenceCount.put(it, referenceCount.getOrDefault(it, 0) + 1)
                }
                TreeNode(name, weight, children.orEmpty())
            }
            else -> throw Exception("Invalid line: $line")
        }
    }

    private fun calculateWeight(nodes: List<TreeNode>, register: Map<String, TreeNode>): Int {
        return nodes.map { calculateWeight(it, register) }.sum()
    }

    private fun calculateWeight(node: TreeNode, register: Map<String, TreeNode>): Int {
        return when (node.hasChildren()) {
            false -> node.weight
            true -> node.weight + calculateWeight(node.children.mapNotNull { register[it] }.toList(), register)
        }
    }

    fun isBalanced(node: TreeNode, register: Map<String, TreeNode>): Boolean {
        return when (node.hasChildren()) {
            false -> true
            true -> node.children.mapNotNull { register[it] }.map { calculateWeight(it, register) }.distinct().size == 1
        }
    }

    data class TreeNode(val name: String, val weight: Int, val children: List<String>) {
        fun hasChildren(): Boolean = children.isNotEmpty()
    }

}