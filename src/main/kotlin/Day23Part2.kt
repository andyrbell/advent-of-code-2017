class Day23Part2 {
    fun solve(b: Int, c: Int): Int {

        fun isPrime(x: Int): Boolean = x.toBigInteger().isProbablePrime(2)

        return (b..c step 17).filter { !isPrime(it) }.count()
    }
}