package reloaded.abstractions.extensions.simple


fun main(args: Array<String>) {
    println("abc".lastChar())
}





fun String.lastChar(): Char {

    return this[this.length - 1]

}

