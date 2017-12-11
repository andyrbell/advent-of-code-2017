import java.lang.Math.max

class Day11Part1 {
    fun solve(input: String): Int {
        val instructions = Utils.splitCsv(input)

        val original = Hex(0, 0, 0)
        val position = instructions.fold(original, { acc, instruction ->
            when (instruction) {
                "n" -> Hex(acc.x, acc.y + 1, acc.z - 1)
                "ne" -> Hex(acc.x + 1, acc.y, acc.z - 1)
                "se" -> Hex(acc.x + 1, acc.y - 1, acc.z)
                "s" -> Hex(acc.x, acc.y - 1, acc.z + 1)
                "sw" -> Hex(acc.x - 1, acc.y, acc.z + 1)
                "nw" -> Hex(acc.x - 1, acc.y + 1, acc.z)
                else -> throw Exception("Invalid move: $instruction")
            }
        })

        return position.max()
    }

    data class Hex(val x: Int, val y: Int, val z: Int) {
        fun max(): Int = max(max(x, y), z)
    }

}