class Day03Part1 {
    fun solve(input: Int): Int {

        val x = IntProgression.fromClosedRange(1, Int.MAX_VALUE, 1)
                .first { (2 * it - 1) * (2 * it - 1) >= input }

        val bottomRightCorner = Pair(x - 1, -(x - 1))
        val bottomRightValue = (2 * x - 1) * (2 * x - 1)

        val point = find(Point(bottomRightCorner, bottomRightValue, x - 1), input)

        return distance(point.location)
    }

    private tailrec fun find(position: Point, value: Int) : Point = when (position.value == value) {
        true -> position
        else -> find(position.next(), value)
    }

    private fun distance(location: Pair<Int, Int>) = Math.abs(location.first) + Math.abs(location.second)

    data class Point(val location: Pair<Int, Int>, val value: Int, private val edge: Int) {
        fun next(): Point {
            val nextLocation: Pair<Int, Int> = when {
                location.second == -edge && location.first > -edge -> Pair(location.first - 1, location.second)
                location.first == -edge && location.second < edge -> Pair(location.first, location.second + 1)
                location.second == edge && location.first < edge -> Pair(location.first + 1, location.second)
                location.first == edge && location.second > -edge -> Pair(location.first, location.second - 1)
                else -> throw IllegalStateException("it's all gone wrong!")
            }
            return Point(nextLocation, value - 1, edge)
        }
    }
}
