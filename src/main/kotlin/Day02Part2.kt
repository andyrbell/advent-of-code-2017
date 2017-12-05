import Utils.toInts

class Day02Part2 {
    fun checksum(line: String): Int {

        val fields = toInts(line).sorted().reversed()
        val combinations = fields.flatMap { field -> fields.map { Pair(field, it) } }
        println(combinations)

        return combinations
                .filter { it.first > it.second }
                .map { (first, second) -> when (first % second) {
                    0 -> first / second
                    else -> 0
                } }.first { it > 0 }
    }

    fun checksum(lines: List<String>): Int = lines.map { checksum(it) }.sum()
}