object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        // Take the collection at every int and unravel it to make the map
        val unraveledMap = mutableMapOf<Char, Int>()
        for ((key, item) in source.entries) {
            item.forEach { unraveledMap[it.toLowerCase()] = key }
        }
        return unraveledMap
    }
}
