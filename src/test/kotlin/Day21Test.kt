import Utils.Matrix
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Day21Test {
    @Test
    fun flipVerticle() {
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

}