import Utils.toBitString

class Day15Part1 {
    fun solve(aSeed: Long, bSeed: Long): Long {

        val generatorA = generateSequence(aSeed) { (it * 16807) % 2147483647 }.drop(1)
        val generatorB = generateSequence(bSeed) { (it * 48271) % 2147483647 }.drop(1)

        return generatorA.zip(generatorB).take(40_000_000)
                .count {
                    toBitString(it.first).takeLast(16) == toBitString(it.second).takeLast(16)
                }.toLong()
    }
}

