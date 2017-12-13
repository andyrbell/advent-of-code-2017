import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import javax.script.ScriptEngineManager
import kotlin.test.assertEquals

class Day08Test {
    @Test
    fun part1() {
        val input = Utils.readLines("src/test/resources/Day08Test.txt")
        assertThat(Day08Part1().solve(input)).isEqualTo(1)
    }

    @Test
    fun part2() {
        val input = Utils.readLines("src/test/resources/Day08Test.txt")
        assertThat(Day08Part2().solve(input)).isEqualTo(10)
    }

    @Test
    fun scripting() {
        // could possibly use this...?
        val map = hashMapOf("a" to 1, "b" to 2, "c" to 3)

        val scriptEngineManager = ScriptEngineManager()
        val engine = scriptEngineManager.getEngineByExtension("kts")!!

        map.forEach({key, value -> engine.eval("val $key = $value")})

        val res = engine.eval("a + 2")

        println("$res")
        assertEquals(3, res)
    }

    @Test
    fun solvePart1() {
        val input = Utils.readLines("src/main/resources/Day08.txt")
        println("Part 1: " + Day08Part1().solve(input))
    }

    @Test
    fun solvePart2() {
        val input = Utils.readLines("src/main/resources/Day08.txt")
        println("Part 2: " + Day08Part2().solve(input))
    }
}