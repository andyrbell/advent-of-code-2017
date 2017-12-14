class Day14Part1 {
    fun solve(input: String): Int {
        return (0..127).map { Day10Part2().solve("$input-$it") }
                .map { Utils.toBitString(it) }
                .map { it.replace("0", "").length }
                .sum()
    }
}