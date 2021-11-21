object Isogram {

    fun isIsogram(input: String): Boolean {
        val charSet = mutableSetOf<Char>()
        // remove special characters
        var str = input.replace("-","")
        str = str.replace(" ", "")
        for (c in str.toLowerCase()) {
            if (charSet.contains(c)) return false
            charSet.add(c)
        }
        return true
    }
}
