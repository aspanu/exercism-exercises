object Luhn {

    fun isValid(candidate: String): Boolean {
        // Remove all spaces
        // Use a lookup table to replace every other digit with double but if >=10, double - 9
        // Sum up all of the digits in the resulting number
        val noSpaces = candidate.replace(" ", "").reversed()
        if (noSpaces.length <= 1) return false

        if (noSpaces.contains(Regex("[^0-9]"))) return false

        val lookupTable = mapOf('0' to '0', '1' to '2', '2' to '4', '3' to '6', '4' to '8', '5' to '1'
            , '6' to '3', '7' to '5', '8' to '7', '9' to '9')

        var newString = ""
        for (i in noSpaces.indices) {
            newString += if (i % 2 == 1) lookupTable[noSpaces[i]]
                else noSpaces[i]
        }
        var sum = 0
        newString.forEach { sum += Character.getNumericValue(it) }

        return sum % 10 == 0
    }
}
