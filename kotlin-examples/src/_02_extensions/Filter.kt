package _02_extensions

import beans.User
import java.util.Arrays
import java.util.ArrayList
import java.util.Collections

fun main(args : Array<String>) {
    val users = listOf(
            User("John", "Doe", 19),
            User("Jane", "Doe", 22)
    )




    val minors = users.filter({ u -> u.age < 21 })






//    val minors = users.filter{ u -> u.age < 21 }
//    val minors = users.filter<User>({ (u : User) : Boolean -> u.age < 21 })









    println("${minors.size} user(s) over 30 years old")








    val youngestOver20 = users.filter { u -> u.age > 20 } min { a, b -> a.age - b.age}
    println("Youngest over 20: $youngestOver20")
}

infix fun <T> Collection<T>.min(compare : (T, T) -> Int) : T? {
    if (isEmpty()) return null
    val i = iterator()
    var min = i.next()
    while (i.hasNext()) {
        val next = i.next()
        if (compare(min, next) > 0) {
            min = next
        }
    }
    return min
}