import Utils.toInts
import Utils.readLines

class Day02Part1 {
    fun checksum(line: String): Int {
        val minMax = toInts(line).fold(Pair(Int.MAX_VALUE, Int.MIN_VALUE), {
            acc, i -> Pair(Math.min(acc.first, i), Math.max(acc.second, i))
        })

        return minMax.second - minMax.first
    }

    fun checksum(lines: List<String>): Int = lines.map { checksum(it) }.sum()
}