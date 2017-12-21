class Day17Part1 {
    fun solve(input: Int): Int {

        val circularBuffer = CircularBuffer(input)

        (1..2017).forEach { circularBuffer.add(it) }

        return circularBuffer.next()
    }

    data class CircularBuffer(private val step: Int, private val buffer: MutableList<Int> = mutableListOf(0), private var index: Int = 0) {
        fun add(value: Int) {
            if (value < 10) println("$value: $buffer")
            val newIndex = ((index + step) % buffer.size) + 1
            buffer.add(newIndex, value)
            index = newIndex
        }

        fun next(): Int = buffer[(index + 1) % buffer.size]
    }

}