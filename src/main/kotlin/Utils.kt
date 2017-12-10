import java.io.File

object Utils {
    fun readLines(filename: String) : List<String> = File(filename).bufferedReader().readLines()

    fun toWords(line: String): List<String> = line.trim().split("\\s+".toRegex())

    fun toInts(line: String): List<Int> = toWords(line).map { Integer.valueOf(it) }

    fun String.sorted(): String = this.toCharArray().sortedArray().contentToString()

    fun toIntArray(lines: List<String>): IntArray = lines.map { Integer.valueOf(it) }.toIntArray()

    fun toIntArray(line: String): IntArray = toWords(line).map { Integer.valueOf(it) }.toIntArray()

    fun splitCsv(line: String): List<String> = line.trim().split(""",\s*""".toRegex())

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

    fun IntArray.wrappedSubArray(start: Int, length: Int): IntArray {
        val original = this
        return IntArray(length, { i -> original[(start + i) % original.size]})
    }

    fun IntArray.wrappedSet(index: Int, value: Int) {
        this[index % size] = value
    }

    fun IntArray.wrappedSet(start: Int, subArray: IntArray): IntArray {
        subArray.forEachIndexed { index, i -> wrappedSet(start + index, i) }
        return this
    }
}