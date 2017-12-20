import Utils.plus

class Day20Part2 {

    private val regex = """p=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>,\s+v=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>,\s+a=<([-\s]?\d+),([-\s]?\d+),([-\s]?\d+)>""".toRegex()

    fun solve(input: List<String>): Int {

        var particles = input.mapIndexed { index, line -> parse(index, line) }

        repeat(10000, {
            particles.forEach { it.move() }
            particles = particles.groupBy { it.position }
                    .filter { it.value.size == 1 }
                    .map { it.value[0] }

        })

        return particles.size
    }

    fun parse(id: Int, line: String): Particle {

        println(line)
        val (px, py, pz, vx, vy, vz, ax, ay, az) = regex.find(line)!!.destructured

        return Particle(id,
                Triple(px.trim().toLong(), py.trim().toLong(), pz.trim().toLong()),
                Triple(vx.trim().toLong(), vy.trim().toLong(), vz.trim().toLong()),
                Triple(ax.trim().toLong(), ay.trim().toLong(), az.trim().toLong())
        )
    }

    data class Particle(val id: Int, var position: TripLong, var velocity: TripLong, var acceleration: TripLong) {
        fun move() {
            velocity = velocity.plus(acceleration)
            position = position.plus(velocity)
        }
    }
}