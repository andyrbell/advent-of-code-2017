import java.lang.Math.max

class Day11Part2 {
    fun solve(input: String): Int {
        val instructions = Utils.splitCsv(input)

        val original = State(Hex(0, 0, 0), 0)
        val state = instructions.fold(original, { acc, instruction ->
            when (instruction) {
                "n" -> State(Hex(acc.position.x, acc.position.y + 1, acc.position.z - 1), acc.max())
                "ne" -> State(Hex(acc.position.x + 1, acc.position.y, acc.position.z - 1), acc.max())
                "se" -> State(Hex(acc.position.x + 1, acc.position.y - 1, acc.position.z), acc.max())
                "s" -> State(Hex(acc.position.x, acc.position.y - 1, acc.position.z + 1), acc.max())
                "sw" -> State(Hex(acc.position.x - 1, acc.position.y, acc.position.z + 1), acc.max())
                "nw" -> State(Hex(acc.position.x - 1, acc.position.y + 1, acc.position.z), acc.max())
                else -> throw Exception("Invalid move: $instruction")
            }
        })

        return state.max()
    }

    data class Hex(val x: Int, val y: Int, val z: Int) {
        fun max(): Int = max(max(x, y), z)
    }

    data class State(val position: Hex, val maxDistance: Int) {
        fun max(): Int = max(position.max(), maxDistance)
    }

}