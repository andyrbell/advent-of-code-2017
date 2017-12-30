import Utils.Matrix
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day21Test {
    @Test
    fun flipVertical() {
        val matrix = Matrix(listOf("..", ".#"))
        val vFlipped = Matrix(listOf("..", "#."))
        assertThat(matrix.vFlip()).isEqualTo(vFlipped)
    }

    @Test
    fun flipHorizontal() {
        val matrix = Matrix(listOf("..", ".#"))
        val hFlipped = Matrix(listOf(".#", ".."))
        assertThat(matrix.hFlip()).isEqualTo(hFlipped)
    }

    @Test
    fun rotate90() {
        val matrix2x2 = Matrix(listOf("01", "23"))
        val rotated2x2By90 = Matrix(listOf("20", "31"))
        assertThat(matrix2x2.rotate90()).isEqualTo(rotated2x2By90)

        val matrix3x3 = Matrix(listOf("012", "345", "678"))
        val rotated3x3By90 = Matrix(listOf("630", "741", "852"))
        assertThat(matrix3x3.rotate90()).isEqualTo(rotated3x3By90)
    }

    @Test
    fun rotate180() {
        val matrix2x2 = Matrix(listOf("01", "23"))
        val rotated2x2By180 = Matrix(listOf("32", "10"))
        assertThat(matrix2x2.rotate180()).isEqualTo(rotated2x2By180)

        val matrix3x3 = Matrix(listOf("012", "345", "678"))
        val rotated3x3By180 = Matrix(listOf("876", "543", "210"))
        assertThat(matrix3x3.rotate180()).isEqualTo(rotated3x3By180)
    }

    @Test
    fun rotate270() {
        val matrix2x2 = Matrix(listOf("01", "23"))
        val rotated2x2By270 = Matrix(listOf("13", "02"))
        assertThat(matrix2x2.rotate270()).isEqualTo(rotated2x2By270)

        val matrix3x3 = Matrix(listOf("012", "345", "678"))
        val rotated3x3By270 = Matrix(listOf("258", "147", "036"))
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
        val matrix3x3 = Matrix(listOf("123", "456", "789"))
        val rotated3x3By90 = Matrix(listOf("741", "852", "963"))
        val rotated3x3By180 = Matrix(listOf("987", "654", "321"))
        val rotated3x3By270 = Matrix(listOf("369", "258", "147"))
        val hflip = Matrix(listOf("789", "456", "123"))
        val vflip = Matrix(listOf("321", "654", "987"))
        val rotated3x3By90hflip = Matrix(listOf("963", "852", "741"))
        val rotated3x3By90vflip = Matrix(listOf("147", "258", "369"))

        val expected = setOf(
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
        val matrix2x2 = Matrix(listOf("01", "23"))
        val rotated2x2By90 = Matrix(listOf("20", "31"))
        val rotated2x2By180 = Matrix(listOf("32", "10"))
        val rotated2x2By270 = Matrix(listOf("13", "02"))
        val hflip = Matrix(listOf("23", "01"))
        val vflip = Matrix(listOf("10", "32"))
        val rotated2x2By90hflip = Matrix(listOf("31", "20"))
        val rotated2x2By90vflip = Matrix(listOf("02", "13"))

        val expected = setOf(
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
}