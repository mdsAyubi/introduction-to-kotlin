package reloaded.abstractions.extensions.enhance

import java.io.File


fun File.getExtension(): String {

    val name = name

    val dotIndex = name.lastIndexOf('.')

    return if (dotIndex < 0) ""
           else name.substring(dotIndex + 1)
}


fun main(args: Array<String>) {
    val ext = File("text.txt").getExtension()
    println("Extension: $ext")













    val sb = StringBuilder()

    sb += "Prefix"

    for (i in 1..10) {
        sb += " $i"
    }

    println(sb)

}



operator fun StringBuilder.plusAssign(a: Any) {
    append(a)
}
