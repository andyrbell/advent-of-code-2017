import Utils.toInts
import java.lang.Math.min
import java.lang.Math.max

class Day02Part1 {
    fun checksum(line: String): Int = toInts(line).fold(Pair(Int.MAX_VALUE, Int.MIN_VALUE), {
        acc, i -> Pair(min(acc.first, i), max(acc.second, i))
    }).let { it.second - it.first }

    fun checksum(lines: List<String>): Int = lines.map { checksum(it) }.sum()
}