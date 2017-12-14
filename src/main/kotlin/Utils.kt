import java.io.File

object Utils {
    fun readLines(filename: String) : List<String> = File(filename).bufferedReader().readLines()

    fun toWords(line: String): List<String> = line.trim().split("\\s+".toRegex())

    fun toInts(line: String): List<Int> = toWords(line).map { Integer.valueOf(it) }

    fun String.sorted(): String = this.toCharArray().sortedArray().contentToString()

    fun toIntArray(lines: List<String>): IntArray = lines.map { Integer.valueOf(it) }.toIntArray()

    fun toIntArray(line: String): IntArray = toWords(line).map { Integer.valueOf(it) }.toIntArray()

    fun splitCsv(line: String): List<String> = line.trim().split(""",\s*""".toRegex())

    fun toPair(line: String): Pair<Int, Int> = line.trim().split(""":\s""".toRegex())
                                                            .map { Integer.valueOf(it) }
                                                            .let { list -> Pair(list[0], list[1]) }

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

    fun Pair<Int, Int>.adjacentNeighbours(): List<Pair<Int, Int>> =
            listOf(
                    Pair(this.first, this.second - 1),
                    Pair(this.first, this.second + 1),
                    Pair(this.first - 1, this.second),
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

    fun IntArray.plus(elements: IntArray, times: Int): IntArray {
        var result: IntArray = this.copyOf()
        for (i in 1..(times-1)) result = result.plus(elements)
        return result
    }

    fun Int.toHex(): String = String.format("%0${2}x", this)

    fun toBits(s: String): String = String.format("%4s", Integer.toBinaryString(Integer.parseInt(s, 16))).replace(' ', '0')

    fun toBits(c: Char): String = toBits(Character.toString(c))

    fun toBitString(s: String): String = s.toCharArray().map { toBits(it) }.joinToString(separator = "")
}