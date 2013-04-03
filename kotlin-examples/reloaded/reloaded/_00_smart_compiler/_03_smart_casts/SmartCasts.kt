package reloaded.smart_compiler.smart_casts

class Box(val x: Int)

fun casts(a: Any) {
    if (a is Box) {
        val box = a as Box
        println("In a box: ${box.x}")
    }
    else {
        println("$a is not a box")
    }
}

fun main(args: Array<String>) {
    casts(1)
    casts(Box(2))
}