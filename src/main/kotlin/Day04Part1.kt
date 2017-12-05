import Utils.toWords

class Day04Part1 {
    fun validate(passphrase: String): Boolean {
        val words = toWords(passphrase)
        return when (words.distinct().size) {
            words.size -> true
            else -> false
        }
    }

    fun countValid(lines: List<String>): Int {
        return lines.filter { validate(it) }.count()
    }
}