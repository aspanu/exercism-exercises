fun <T> List<T>.customAppend(list: List<T>): List<T> {
    val listTo = this.toMutableList()
    for (i in list) {
        listTo.add(i)
    }
    return listTo
}

fun List<Any>.customConcat(): List<Any> {
    val finalList = mutableListOf<Any>()
    
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    TODO("Implement this function to complete the task")
}

val List<Any>.customSize: Int get() = TODO("Implement this getter to complete the task")

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    TODO("Implement this function to complete the task")
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    TODO("Implement this function to complete the task")
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    TODO("Implement this function to complete the task")
}

fun <T> List<T>.customReverse(): List<T> {
    TODO("Implement this function to complete the task")
}
