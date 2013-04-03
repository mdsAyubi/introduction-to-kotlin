package reloaded.smart_compiler.parameters

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)

    println(makeString(list, ", ", "(", ")"))

    println(makeString(list, ", "))
}

fun <T> makeString(c: Collection<T>, separator: String): String {
    return makeString(c, separator, "", "")
}

fun <T> makeString(c: Collection<T>, separator: String, prefix: String, suffix: String): String {
    val result = StringBuilder(prefix)
    val it = c.iterator()
    while (it.hasNext()) {
        result.append(it.next())
        if (it.hasNext()) {
            result.append(separator)
        }
    }
    result.append(suffix)
    return result.toString()
}