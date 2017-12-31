import Utils.plus

object Day24Part2 {
    fun solve(input: List<String>): Int {
        val components = parse(input)

        val bridges = solve(components)

        val longestBridges = bridges.groupBy { it.size }.maxBy { it.key }!!.value

        return longestBridges.map { it.reduce { x, y -> x.plus(y)}.let { it.first + it.second } }.max()!!
    }

    fun solve(components: List<Component>, bridge: List<Component> = mutableListOf(), port: Int = 0): List<List<Component>> {
        val available = components.filter { it.first == port || it.second == port }

        return if (available.isEmpty()) {
            listOf(bridge)
        } else {
            available.flatMap {
                val otherPort = if (it.first == port) it.second else it.first
                solve(components.minus(it), bridge.plus(it), otherPort)
            }
        }
    }


    private fun parse(input: List<String>): List<Component> = input.map { it.split("/") }
            .map { Component(it[0].toInt(), it[1].toInt()) }


}
