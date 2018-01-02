class Day01Part1 {
    fun part1(s: String): Int = part1(0, s, 0)

    private fun part1(acc: Int, input: String, index: Int) : Int = when (index) {
        input.length - 1 -> when {
            input[index] == input[0] -> acc + Character.toString(input[index]).toInt()
            else -> acc
        }
        else -> when {
            input[index] == input[index + 1] -> part1(acc + Character.toString(input[index]).toInt(), input, index + 1)
            else -> part1(acc, input, index + 1)
        }
    }
}