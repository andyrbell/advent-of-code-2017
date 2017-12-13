class Day07Part1 {
    fun solve(input: List<String>): String {
        val referenceCount = mutableMapOf<String, Int>()
        input.map { parseNode(it, referenceCount) }.associateBy { it.name }

        return referenceCount.entries.first { it.value == 1 }.key
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
                TreeNode(name, weight, children)
            }
            else -> throw Exception("Invalid line: $line")
        }
    }

    data class TreeNode(val name: String, val weight: Int, val children: List<String>? = emptyList())

}