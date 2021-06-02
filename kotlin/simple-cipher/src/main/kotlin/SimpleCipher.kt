import kotlin.random.Random

data class Cipher(val key: String = createRandomKey()) {

    init {
        if (key.contains(Regex("[^a-z]"))) {
            throw IllegalArgumentException("Key cannot contain non lower case characters.")
        }
        if (key.isBlank()) {
            throw IllegalArgumentException("Key cannot be empty.")
        }
    }

    fun encode(s: String): String {
        // For every item encoding string, move the characters by the offset given by the position in the
        // alphabet. I.e. -> a == 0, b == 1
        var encodedMessage = ""
        for (i in s.indices) {
            val newIndex = (ALPHABET.indexOf(s[i].toString()) + ALPHABET.indexOf(key[i % key.length].toString())) % ALPHABET.size
            encodedMessage += ALPHABET[newIndex]
        }
        return encodedMessage
    }

    fun decode(s: String): String {
        var decodedMessage = ""
        for (i in s.indices) {
            val newIndex = ((ALPHABET.indexOf(s[i].toString()) - ALPHABET.indexOf(key[i % key.length].toString())) + ALPHABET.size) % ALPHABET.size
            decodedMessage += ALPHABET[newIndex]
        }
        return decodedMessage
    }
}

private val ALPHABET = "a b c d e f g h i j k l m n o p q r s t u v w x y z".split(" ")

private fun createRandomKey(): String {
    var key = ""
    for (i in 1..100) {
        key += ALPHABET[Random.nextInt(ALPHABET.size)]
    }
    return key
}
