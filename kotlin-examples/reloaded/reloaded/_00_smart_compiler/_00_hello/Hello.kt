package reloaded._00_hello

class Greeter {
    fun greet() {
        println("Hello, OOP!")
    }
}

fun main(args : Array<String>) {
    println("Hello, world!")
    Greeter().greet()
}