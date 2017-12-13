class Day13Part2 {
    fun solve(input: List<String>): Int {

        val firewallLayers = input.map { Utils.toPair(it) }.toMap().withDefault { _ -> -1 }
        val maxDepth = firewallLayers.keys.max()!!

        fun packetPosition(time: Int): Int = time

        fun caughtByScanner(delay: Int): Boolean {
            var caught = false
            for (t in 0..maxDepth) {
                val packetPosition = packetPosition(t)
                val maxRange = firewallLayers.getValue(packetPosition)
                if (maxRange != -1 && 0 == ((t + delay) % ((maxRange - 1) * 2))) {

                    caught = true
                    break
                }
            }
            return caught
        }

        return (1..Int.MAX_VALUE).first { !caughtByScanner(it) }
    }

}