import java.io.File

object Utils {
    fun readLines(filename: String) : List<String> = File(filename).bufferedReader().readLines()

    fun toWords(line: String): List<String> = line.trim().split("\\s+".toRegex())

    fun toInts(line: String): List<Int> = line.trim().split("\\s+".toRegex()).map { Integer.valueOf(it) }

    fun String.sorted(): String = this.toCharArray().sortedArray().contentToString()

    fun toIntArray(lines: List<String>): IntArray = lines.map { Integer.valueOf(it) }.toIntArray()

    fun toIntArray(line: String): IntArray = toWords(line).map { Integer.valueOf(it) }.toIntArray()

    fun Pair<Int, Int>.neighbours(): List<Pair<Int, Int>> =
        listOf(
                Pair(this.first + 1, this.second - 1),
                Pair(this.first, this.second - 1),
                Pair(this.first - 1, this.second - 1),
                Pair(this.first - 1, this.second),
                Pair(this.first - 1, this.second + 1),
                Pair(this.first, this.second + 1),
                Pair(this.first + 1, this.second + 1),
                Pair(this.first + 1, this.second)
        )

    enum class Direction {
        NORTH, SOUTH, WEST, EAST
    }
}