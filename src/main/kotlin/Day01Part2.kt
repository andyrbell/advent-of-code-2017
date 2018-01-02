class Day01Part2 {
    fun part2(s: String): Int = part2(0, s, 0)

    private fun part2(acc: Int, input: String, index: Int) : Int = when (index) {
        input.length - 1 -> when {
            input[index] == input[(index + input.length/2) % input.length] -> acc + Character.toString(input[index]).toInt()
            else -> acc
        }
        else -> when {
            input[index] == input[(index + input.length/2) % input.length] -> part2(acc + Character.toString(input[index]).toInt(), input, index + 1)
            else -> part2(acc, input, index + 1)
        }
    }
}