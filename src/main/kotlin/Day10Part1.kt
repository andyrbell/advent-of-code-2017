import Utils.wrappedSubArray
import Utils.wrappedSet

class Day10Part1 {
    fun solve(list: IntArray, input: IntArray): Int {
        return input.fold(State(list, 0, 0), { acc, length ->
            val reversedSubArray = acc.list.wrappedSubArray(acc.position, length).reversedArray()
            val newList = acc.list.wrappedSet(acc.position, reversedSubArray)

            State(newList, acc.position + length + acc.skip, acc.skip + 1)
        }).list.take(2).reduce { x, y -> x * y}
    }

    data class State(val list: IntArray, val position: Int, val skip: Int)

}