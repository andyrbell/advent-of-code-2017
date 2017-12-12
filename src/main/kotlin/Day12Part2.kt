import Utils.splitCsv

class Day12Part2 {
    fun solve(input: List<String>): Int {
        val regex = """(\d+) <-> (.*)""".toRegex()
        val nodes = mutableMapOf<String, MutableSet<String>>()

        input.forEach {
            val (nodeId, connectedNodes) = regex.find(it)!!.destructured
            nodes.putIfAbsent(nodeId, mutableSetOf())
            val connectedNodeIds = splitCsv(connectedNodes)
            connectedNodeIds.forEach { connectedNodeId ->
                nodes.putIfAbsent(connectedNodeId, mutableSetOf())
                nodes.getValue(nodeId).add(connectedNodeId)
                nodes.getValue(connectedNodeId).add(nodeId)
            }
        }
        return nodes.keys.map { countNodes(nodes, mutableSetOf(), it) }
                .toSet().size
    }

    private fun countNodes(nodes: MutableMap<String, MutableSet<String>>, visited: MutableSet<String> = mutableSetOf(), nodeId: String = "0"): MutableSet<String> {
        return when (visited.contains(nodeId)) {
            true -> visited
            false -> {
                visited.add(nodeId)
                return nodes.getValue(nodeId).map { countNodes(nodes, visited, it) }.reduce { x, y -> x.plus(y).toMutableSet() }
            }
        }
    }
}

