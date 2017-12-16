class Day16Part1 {
    fun solve(moves: List<String>, positions: String): String {
        return moves.fold(positions, { acc, move ->
            when (move.take(1)) {
                "s" -> spin(acc, Integer.parseInt(move.drop(1)))
                "x" -> {
                    val indexes = move.drop(1).split("/")
                    exchange(acc, Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]))
                }
                "p" -> {
                    val indexes = move.drop(1).split("/")
                    partner(acc, indexes[0][0], indexes[1][0])
                }
                else -> throw Exception("invalid move: $move")
            }
        })
    }

    fun spin(positions: String, size: Int): String {
        val result = positions.takeLast(size) + positions.take(positions.length - size)
        println("spin: $positions -> $result")
        return result
    }

    fun exchange(positions: String, x: Int, y: Int): String {
        val xChar = positions.get(x)
        val yChar = positions.get(y)

        val chars = positions.toCharArray()
        chars[y] = xChar
        chars[x] = yChar

        val result = String(chars)
        println("exchange: $positions -> $result")
        return result
    }

    fun partner(positions: String, x: Char, y: Char): String {
        val xIdx = positions.indexOf(x)
        val yIdx = positions.indexOf(y)

        val chars = positions.toCharArray()
        chars[xIdx] = y
        chars[yIdx] = x

        val result = String(chars)
        println("partner: $positions -> $result")
        return result
    }
}