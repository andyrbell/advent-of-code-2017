import Utils.toInts

class Day02Part2 {
    fun checksum(line: String): Int {

        // WIP
        return 0
    }

    fun checksum(lines: List<String>): Int = lines.map { checksum(it) }.sum()
}