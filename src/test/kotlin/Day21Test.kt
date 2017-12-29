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

}