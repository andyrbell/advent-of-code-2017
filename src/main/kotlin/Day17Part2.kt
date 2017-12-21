class Day17Part2 {
    fun solve(input: Int): Int {

        val circularBuffer = CircularBuffer(input)

        (1..50_000_000).forEach { circularBuffer.add(it) }

        return circularBuffer.next()
    }

    data class CircularBuffer(private val step: Int,
                              private var index: Int = 0,
                              private var indexOfZero: Int = 0,
                              private var valueAfterZero: Int = 1) {
        fun add(value: Int) {
            val newIndex = ((index + step) % value) + 1

            when (newIndex) {
                indexOfZero -> indexOfZero++
                1 -> valueAfterZero = value
            }
            index = newIndex
        }

        fun next(): Int {
            return valueAfterZero
        }
    }

}