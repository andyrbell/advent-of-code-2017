import Utils.readLines
import Utils.splitCsv
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day12Test {
    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day12Test.txt")
        assertThat(Day12Part1().solve(input)).isEqualTo(6)
    }

    @Test
    fun parseNode() {
        val input = "2 <-> 0, 3, 4"

        val regex = """(\d+) <-> (.*)""".toRegex()

        val (nodeId, connectedNodes) = regex.find(input)!!.destructured

        val connectedNodeId = splitCsv(connectedNodes)

        assertThat(nodeId).isEqualTo("2")
        assertThat(connectedNodeId).contains("0", "3", "4")


    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day12.txt")
        println("Part 1: " + Day12Part1().solve(input))

    }

}