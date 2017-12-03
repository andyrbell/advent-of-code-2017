import java.io.File

class Day01 {
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

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            println(File("src/main/resources/Day01.txt").readText().trim())
            println("Part 1: " + Day01().part1(File("src/main/resources/Day01.txt").readText().trim()))
            println("Part 2: " + Day01().part2(File("src/main/resources/Day01.txt").readText().trim()))
        }
    }

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