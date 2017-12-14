import Utils.adjacentNeighbours

class Day14Part2 {
    fun solve(input: String): Int {
        val grid = (0..127).map { Day10Part2().solve("$input-$it") }
                .map { Utils.toBitString(it) }
                .map { it.toCharArray().map { Integer.valueOf(Character.toString(it)) } }
                .toTypedArray()


        val usedGrid = mutableSetOf<Pair<Int,Int>>()

        for (y in 0..127) {
            (0..127)
                    .filter { x -> grid[y][x] == 1 }
                    .forEach { x -> usedGrid.add(Pair(x, y)) }
        }
        val allComponents = usedGrid.map { countNodes(usedGrid, mutableSetOf(), it) }
        return allComponents
                .toSet().size
    }

    private fun countNodes(usedGrid: MutableSet<Pair<Int, Int>>, visited: MutableSet<Pair<Int, Int>> = mutableSetOf(), nodeId: Pair<Int, Int> = Pair(0, 0)): MutableSet<Pair<Int, Int>> {
        return when (visited.contains(nodeId)) {
            true -> {
//                println("already visited: $nodeId")
                visited
            }
            false -> {
//                println("adding to visited: $nodeId")
                visited.add(nodeId)
                return nodeId.adjacentNeighbours()
                        .filter { usedGrid.contains(it) }
                        .map { countNodes(usedGrid, visited, it) }
                        .flatten()
                        .toMutableSet()

            }
        }
    }
}