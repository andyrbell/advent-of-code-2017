class Day14Part2 {
    fun solve(input: String): Int {
        val grid = (0..127).map { Day10Part2().solve("$input-$it") }
                .map { Utils.toBitString(it) }
                .map { it.chars().toArray()!! }
                .toTypedArray()

        val regions = mutableMapOf<Pair<Int,Int>, Set<Pair<Int,Int>>>()
        for (y in 0..127) {
            (0..127)
                    .filter { grid[y][it] == 1 }
                    .forEach {
                        // find used neighbours

                        // any neighbours in existing regions?
                        // add to regions
                        // else
                        // add new region
                    }
        }

        return regions.keys.size
    }
}