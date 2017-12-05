class Day05Part1 {

    tailrec fun solve(input: IntArray, offset: Int = 0, acc: Int = 1): Int {

        val newIndex = offset + input[offset]

        return when {
            newIndex < 0 -> acc
            newIndex > input.size - 1 -> acc
            else -> {
                input[offset]++
                return solve(input, newIndex, acc + 1)
            }
        }
    }

}
