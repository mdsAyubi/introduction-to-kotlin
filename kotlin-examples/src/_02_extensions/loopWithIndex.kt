package _02_extensions.loopWithIndex

fun main(args: Array<String>) {
    val list = listOf("a", "b", "c")

    for ((i, v) in list.withIndices()) {
        println("list[$i] = $v")
    }
}







fun <T> Iterable<T>.loopWithIndex(body: (index: Int, value: T) -> Unit) {
    var i = 0
    for (v in this) {
        body(i, v)
        i++
    }
}