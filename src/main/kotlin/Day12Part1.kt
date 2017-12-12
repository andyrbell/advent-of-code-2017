import Utils.splitCsv

class Day12Part1 {
    fun solve(input: List<String>): Int {


        val nodes = mutableMapOf<String, Node>().withDefault { it -> Node(it) }
        val edges = mutableMapOf<Node, Set<Node>>()

        input.forEach {
            val regex = """(\d+) <-> (.*)""".toRegex()

            val (nodeId, connectedNodes) = regex.find(it)!!.destructured

            val connectedNodeIds = splitCsv(connectedNodes)

            val node = nodes.getValue(nodeId)
            connectedNodeIds.forEach {
                val connectedNode = nodes.getValue(it)
                connectedNode.connectedTo.add(node)
                node.connectedTo.add(connectedNode)
            }

        }
        println(nodes)
        return 0
    }


    data class Node(val id: String, val connectedTo: MutableList<Node> = emptyList<Node>().toMutableList())


}

