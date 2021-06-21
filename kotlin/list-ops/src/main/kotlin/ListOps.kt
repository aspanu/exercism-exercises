fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val listTo = this.toMutableList()
    for (i in list) {
        listTo.add(i)
    }
    return listTo
}

fun List<Any>.customConcat(): List<Any> {
    val finalList = mutableListOf<Any>()
    this.forEach { if (it is List<*>) { finalList.addAll((it as List<Any>).customConcat()) } else { finalList.add(it) } }
    return finalList
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    val filteredList = mutableListOf<T>()
    this.forEach { if (predicate(it)) filteredList.add(it) }
    return filteredList
}

val List<Any>.customSize: Int get() {
    var size = 0
    this.forEach { _ -> size++ }
    return size
}

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    val mappedList = mutableListOf<U>()
    this.forEach { mappedList.add(transform(it)) }
    return mappedList
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    if (this.isEmpty()) return initial
    var finalValue : U? = null
    for (i in this.indices) {
        if (finalValue != null) {
            finalValue = f(finalValue, this[i])
        } else {
            finalValue = f(initial, this[i])
        }
    }
    return finalValue!!
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    if (this.isEmpty()) return initial
    var finalValue : U? = null
    for (i in this.indices.reversed()) {
        if (finalValue != null) {
            finalValue = f(this[i], finalValue)
        } else {
            finalValue = f(this[i], initial)
        }
    }
    return finalValue!!
}

fun <T> List<T>.customReverse(): List<T> {
    val reversedList = mutableListOf<T>()
    for (i in this.size - 1 downTo 0) {
        reversedList.add(this[i])
    }
    return reversedList
}
