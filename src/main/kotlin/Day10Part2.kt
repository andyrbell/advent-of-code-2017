import Utils.plus
import Utils.toHex
import Utils.wrappedSet
import Utils.wrappedSubArray

class Day10Part2 {
    fun solve(input: String, listSize: Int = 256): String {
        val list = IntArray(listSize, { it })
        val asciiCodes = input.map { it.toInt() }.toIntArray().plus(intArrayOf(17, 31, 73, 47, 23))

        val sparseHash = hashRound(list, asciiCodes, 64)
        return sparseHash
                .toList()
                .chunked(16, { it.reduce { x, y -> x.xor(y)}.toHex() })
                .joinToString("")
    }

    fun hashRound(list: IntArray, input: IntArray, times: Int): IntArray {

        return input.plus(input, times)
                    .fold(State(list, 0, 0), { acc, length ->
            val reversedSubArray = acc.list.wrappedSubArray(acc.position, length).reversedArray()
            val newList = acc.list.wrappedSet(acc.position, reversedSubArray)

            State(newList, acc.position + length + acc.skip, acc.skip + 1)
        }).list
    }

    data class State(val list: IntArray, val position: Int, val skip: Int)

}