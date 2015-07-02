package reloaded._04_extensions

import subsequence.*

fun main(args: Array<String>) {
    val s = "Hello"
    println(   s                )
    println(   s[1..2]          )
    println(   s[FIRST..LAST]   )
    println(   s[FIRST..2]      )
    println(   s[2..LAST]       )

    val l = listOf(1, 2, 3, 4)
    println(l)
    println(l[1..2])
    println(l[FIRST..LAST])

    println(l[0..3 step 2])
    println(l[3 downTo 0 step 2])

    println(l[FIRST..2])
    println(l[2..LAST])
    println(l[2..LAST - 1])
}