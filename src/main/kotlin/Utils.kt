
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

    fun Pair<Int, Int>.adjacentNeighbours(): List<Pair<Int, Int>> {
        val neighbours = mutableListOf(
                Pair(this.first, this.second - 1),
                Pair(this.first, this.second + 1),
                Pair(this.first - 1, this.second),
                Pair(this.first + 1, this.second)
        )

        if (this.first == 127) {
            neighbours.add(Pair(0, this.second + 1))
        }

        return neighbours
    }

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

    operator fun Pair<Int, Int>.plus(other: Pair<Int, Int>): Pair<Int, Int> = Pair(first + other.first, second + other.second)

    fun Int.toHex(): String = String.format("%0${2}x", this)

    fun toBits(s: String): String = String.format("%4s", Integer.toBinaryString(Integer.parseInt(s, 16))).replace(' ', '0')

    fun toBits(c: Char): String = toBits(Character.toString(c))

    fun toBitString(s: String): String = s.toCharArray().map { toBits(it) }.joinToString(separator = "")

    fun toBitString(l: Long): String = java.lang.Long.toBinaryString(l).padStart(32, '0')

    fun String.spin(size: Int): String = takeLast(size) + take(length - size)

    fun spin(chars: CharArray, size: Int): CharArray {
        val copy = CharArray(chars.size)
        (0..(chars.size - 1)).forEach { copy[it] = chars[(it + chars.size - size) % chars.size] }
        return copy
    }

    fun String.exchange(x: Int, y: Int): String {
        val xChar = get(x)
        val yChar = get(y)

        val chars = toCharArray()
        chars[y] = xChar
        chars[x] = yChar

        return String(chars)
    }

    fun exchange(chars: CharArray, x: Int, y: Int): CharArray {
        val xChar = chars[x]
        val yChar = chars[y]

        chars[y] = xChar
        chars[x] = yChar

        return chars
    }

    fun String.partner(x: Char, y: Char): String {
        val xIdx = indexOf(x)
        val yIdx = indexOf(y)

        val chars = toCharArray()
        chars[xIdx] = y
        chars[yIdx] = x

        return String(chars)
    }

    fun partner(chars: CharArray, x: Char, y: Char): CharArray {
        val xIdx = chars.indexOf(x)
        val yIdx = chars.indexOf(y)

        chars[xIdx] = y
        chars[yIdx] = x

        return chars
    }

    fun TripLong.plus(other: TripLong): TripLong {
        return Triple(first + other.first, second + other.second, third + other.third)
    }

    data class Matrix(val values: List<String>) {

        constructor(line: String): this(line.split("/"))
        constructor(vararg elements: String): this(elements.toList())

        val size = values.size
        private val noOfLayers = Math.floorDiv(size, 2)

        fun vFlip(): Matrix = Matrix(values.map { it.reversed() })
        fun hFlip(): Matrix = Matrix(values.reversed())
        fun rotate90(): Matrix {
            val newValues = values.map { it.toCharArray() }

            (0..noOfLayers).forEach { first ->
                val last = size - first - 1

                (first until last).forEach { element ->
                    val offset = element - first

                    val top = newValues[first][element]
                    val right = newValues[element][last]
                    val bottom = newValues[last][last-offset]
                    val left = newValues[last-offset][first]

                    newValues[first][element] = left
                    newValues[element][last] = top
                    newValues[last][last-offset] = right
                    newValues[last-offset][first] = bottom
                }
            }

            return Matrix(newValues.map { String(it) })
        }

        fun rotate180(): Matrix = rotate90().rotate90()

        fun rotate270(): Matrix = rotate180().rotate90()

        fun allTransforms(): Set<Matrix> = setOf(
                this,
                vFlip(),
                hFlip(),
                rotate90(),
                rotate180(),
                rotate270(),
                rotate90().hFlip(),
                rotate90().vFlip(),
                rotate180().hFlip(),
                rotate180().vFlip(),
                rotate270().hFlip(),
                rotate270().vFlip()
        )

        fun split(): List<Matrix> = when {
            size % 2 == 0 -> splitBy2()
            size % 3 == 0 -> splitBy3()
            else -> throw IllegalStateException("Size $size not divisible by 2 or 3")
        }

        fun splitBy2(): List<Matrix> {
            return (0 until size step 2).flatMap { y ->
                (0 until size step 2).map { x ->
                    Matrix(listOf(values[y].substring(x, x + 2), values[y + 1].substring(x, x + 2)))
                }
            }
        }

        fun splitBy3(): List<Matrix> {
            return (0 until size step 3).flatMap { y ->
                (0 until size step 3).map { x ->
                    Matrix(listOf(values[y].substring(x, x + 3), values[y + 1].substring(x, x + 3), values[y + 2].substring(x, x + 3)))
                }
            }
        }

        fun count(c: Char = '#'): Int = this.values.map { row -> row.count { element -> element == c } }.sum()

        override fun toString(): String {
            return values.joinToString(separator = "\n", prefix = "\n")
        }
    }

    fun List<Matrix>.join(): Matrix {
        if (size == 1) return first()

        val newMatrixSize = Math.sqrt((size * Math.pow(first().size.toDouble(), 2.0))).toInt()
        val initial = (0 until newMatrixSize).map { "" }.toMutableList()

        val values = foldIndexed(initial, { matrixIndex, acc, matrix ->
            matrix.values.forEachIndexed { matrixElementIndex, s ->
                val offset = Math.floorDiv(matrixIndex * matrix.size, newMatrixSize) * matrix.size
                acc.set(matrixElementIndex + offset, acc.get(matrixElementIndex + offset) + s)
            }
            acc
        })
        return Matrix(values)
    }
}

typealias TripLong = Triple<Long, Long, Long>

