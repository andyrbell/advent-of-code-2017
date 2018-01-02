import Utils.Matrix
import Utils.join
import Utils.readLines
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day21Test {
    @Test
    fun flipVertical() {
        val matrix = Matrix("..", ".#")
        val vFlipped = Matrix("..", "#.")
        assertThat(matrix.vFlip()).isEqualTo(vFlipped)
    }

    @Test
    fun flipHorizontal() {
        val matrix = Matrix("..", ".#")
        val hFlipped = Matrix(".#", "..")
        assertThat(matrix.hFlip()).isEqualTo(hFlipped)
    }

    @Test
    fun rotate90() {
        val matrix2x2 = Matrix("01", "23")
        val rotated2x2By90 = Matrix("20", "31")
        assertThat(matrix2x2.rotate90()).isEqualTo(rotated2x2By90)

        val matrix3x3 = Matrix("012", "345", "678")
        val rotated3x3By90 = Matrix("630", "741", "852")
        assertThat(matrix3x3.rotate90()).isEqualTo(rotated3x3By90)
    }

    @Test
    fun rotate180() {
        val matrix2x2 = Matrix("01", "23")
        val rotated2x2By180 = Matrix("32", "10")
        assertThat(matrix2x2.rotate180()).isEqualTo(rotated2x2By180)

        val matrix3x3 = Matrix("012", "345", "678")
        val rotated3x3By180 = Matrix("876", "543", "210")
        assertThat(matrix3x3.rotate180()).isEqualTo(rotated3x3By180)
    }

    @Test
    fun rotate270() {
        val matrix2x2 = Matrix("01", "23")
        val rotated2x2By270 = Matrix("13", "02")
        assertThat(matrix2x2.rotate270()).isEqualTo(rotated2x2By270)

        val matrix3x3 = Matrix("012", "345", "678")
        val rotated3x3By270 = Matrix("258", "147", "036")
        assertThat(matrix3x3.rotate270()).isEqualTo(rotated3x3By270)
    }

    // 123
    // 456
    // 789
    //
    // hflip vflip
    // 789   321
    // 456   654
    // 123   987
    //
    // rot90  rot90h  rot90v
    // 741    963     147
    // 852    852     258
    // 963    741     369
    //
    // rot180 rot180h rot180v
    // 987    321     789
    // 654    654     456
    // 321    987     123
    //
    // rot270 rot270h rot180v
    // 369    147     963
    // 258    258     852
    // 147    369     741
    @Test
    fun transformSet3x3() {
        val matrix3x3 = Matrix("123", "456", "789")
        val rotated3x3By90 = Matrix("741", "852", "963")
        val rotated3x3By180 = Matrix("987", "654", "321")
        val rotated3x3By270 = Matrix("369", "258", "147")
        val hflip = Matrix("789", "456", "123")
        val vflip = Matrix("321", "654", "987")
        val rotated3x3By90hflip = Matrix("963", "852", "741")
        val rotated3x3By90vflip = Matrix("147", "258", "369")

        val expected = setOf(
                matrix3x3,
                rotated3x3By90,
                rotated3x3By180,
                rotated3x3By270,
                hflip,
                vflip,
                rotated3x3By90hflip,
                rotated3x3By90vflip
        )

        assertThat(matrix3x3.allTransforms()).isEqualTo(expected)
    }

    // 01
    // 23
    //
    // hflip vflip
    // 23    10
    // 01    32
    //
    // rot90    rot90h    rot90v
    // 20       31        02
    // 31       20        13
    //
    // rot180   rot180h   rot180v
    // 32       10        23
    // 10       32        01
    //
    // rot270   rot270h   rot270v
    // 13       02        31
    // 02       13        20
    @Test
    fun transformSet() {
        val matrix2x2 = Matrix("01", "23")
        val rotated2x2By90 = Matrix("20", "31")
        val rotated2x2By180 = Matrix("32", "10")
        val rotated2x2By270 = Matrix("13", "02")
        val hflip = Matrix("23", "01")
        val vflip = Matrix("10", "32")
        val rotated2x2By90hflip = Matrix("31", "20")
        val rotated2x2By90vflip = Matrix("02", "13")

        val expected = setOf(
                matrix2x2,
                rotated2x2By90,
                rotated2x2By180,
                rotated2x2By270,
                hflip,
                vflip,
                rotated2x2By90hflip,
                rotated2x2By90vflip
        )

        assertThat(matrix2x2.allTransforms()).isEqualTo(expected)
    }

    @Test
    fun split() {
        val matrix4x4 = Matrix("0123", "4567", "8901", "2345")
        val expected = listOf(
                Matrix("01", "45"),
                Matrix("23", "67"),
                Matrix("89", "23"),
                Matrix("01", "45")
        )
        assertThat(matrix4x4.split()).isEqualTo(expected)
    }

    @Test
    fun splitBy3() {
        val matrix9x9 = Matrix(listOf(
                "012345678",
                "901234567",
                "890123456",
                "789012345",
                "678901234",
                "567890123",
                "456789012",
                "345678901",
                "234567890"))
        val expected = listOf(
                Matrix("012", "901", "890"),
                Matrix("345", "234", "123"),
                Matrix("678", "567", "456"),
                Matrix("789", "678", "567"),
                Matrix("012", "901", "890"),
                Matrix("345", "234", "123"),
                Matrix("456", "345", "234"),
                Matrix("789", "678", "567"),
                Matrix("012", "901", "890")
        )
        assertThat(matrix9x9.split()).isEqualTo(expected)
    }

    @Test
    fun join2x2() {
        val matrices = listOf(
                Matrix("01", "45"),// 0 0 -> 0, 0 1 -> 1
                Matrix("23", "67"),// 1 0 -> 0, 1 1 -> 1
                Matrix("89", "23"),// 2 0 -> 2, 2 1 -> 3
                Matrix("01", "45") // 3 0 -> 2, 3 1 -> 3     floor(i / rowSize) * rowSize
        )
        val matrix4x4 = Matrix(listOf(
                "0123",
                "4567",
                "8901",
                "2345"))

        assertThat(matrices.join()).isEqualTo(matrix4x4)
    }

    @Test
    fun join3x3() {
        val matrices = listOf(
                Matrix("012", "901", "890"),
                Matrix("345", "234", "123"),
                Matrix("678", "567", "456"),
                Matrix("789", "678", "567"),
                Matrix("012", "901", "890"),
                Matrix("345", "234", "123"),
                Matrix("456", "345", "234"),
                Matrix("789", "678", "567"),
                Matrix("012", "901", "890")
        )
        val matrix9x9 = Matrix(listOf(
                "012345678",
                "901234567",
                "890123456",
                "789012345",
                "678901234",
                "567890123",
                "456789012",
                "345678901",
                "234567890"))

        assertThat(matrices.join()).isEqualTo(matrix9x9)
    }

    @Test
    fun join() {
        val matrices = listOf(
                Matrix("##.", "#..", "..."),// 0 0 -> 0, 0 1 -> 1, 0 2 -> 2
                Matrix("##.", "#..", "..."),// 1 0 -> 0, 1 1 -> 1, 1 2 -> 2
                Matrix("##.", "#..", "..."),// 2 0 -> 3, 2 1 -> 4, 2 2 -> 5
                Matrix("##.", "#..", "...") // 3 0 -> 3, 3 1 -> 4. 3 2 -> 5     floor(i / rowSize) * rowSize
        )
        val matrix6x6 = Matrix(listOf(
                "##.##.",
                "#..#..",
                "......",
                "##.##.",
                "#..#..",
                "......"))

        assertThat(matrices.join()).isEqualTo(matrix6x6)
    }

    @Test
    fun parseMatrix() {
        val matrix = Matrix("#..#/..../..../#..#")
        val expected = Matrix("#..#", "....", "....", "#..#")

        assertThat(matrix).isEqualTo(expected)
    }

    @Test
    fun count() {
        val matrix = Matrix("#..#/..../..../#..#")
        assertThat(matrix.count()).isEqualTo(4)
    }

    @Test
    fun part1() {
        val input = readLines("src/test/resources/Day21Test.txt")
        assertThat(Day21Part1.solve(input, 2)).isEqualTo(12)
    }

    @Test
    fun solvePart1() {
        val input = readLines("src/main/resources/Day21.txt")
        println("Part 1: " + Day21Part1.solve(input, 5))
    }

    @Test
    fun solvePart2() {
        val input = readLines("src/main/resources/Day21.txt")
        println("Part 2: " + Day21Part1.solve(input, 18))
    }
}