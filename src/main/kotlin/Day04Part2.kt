import Utils.toWords
import Utils.sorted

class Day04Part2 {
    fun validate(passphrase: String): Boolean {
        val words = toWords(passphrase)
        return words.groupBy { it.sorted() }
                .none { it.value.size > 1 }
    }

    fun countValid(lines: List<String>): Int = lines.filter { validate(it) }.count()
}