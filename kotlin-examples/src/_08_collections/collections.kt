package _08_collections

import java.util.ArrayList

fun print(list: List<Any>) {
    for (x in list) {
        println(x)
    }
}

fun main(args: Array<String>) {
    val l: List<Int> = listOf(1, 2, 3)

    print(l)
}
