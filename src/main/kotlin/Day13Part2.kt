import Utils.toPair

class Day13Part2 {
    fun solve(input: List<String>): Int {

        val firewallLayers = input.map { toPair(it) }.toMap()

        fun caughtByScanner(delay: Int): Boolean {
            return firewallLayers.entries
                    .any { ((it.key + delay) % ((it.value - 1) * 2)) == 0 }
        }

        return (1..Int.MAX_VALUE).first { !caughtByScanner(it) }
    }
}
