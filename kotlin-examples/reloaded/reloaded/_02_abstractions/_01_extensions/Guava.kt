package reloaded.abstractions.motivation


import com.google.common.collect.Collections2.*
import com.google.common.base.Function
import com.google.common.base.Predicate

fun main(args: Array<String>) {
    val list = listOf("a", "bb", "acc")



    // The way Java 8 will have it
    val gl = transform(
        filter(
               list,
               p { s -> s.startsWith("a")}
        ),
        gf { s -> s.length }
    )

    println(gl)














    // Kotlin's way with extension functions
    val kl = list
                .filter { s -> s.startsWith("a") }
                .map { s -> s.length }

    println(kl)

}































fun p<T>(body: (T) -> Boolean): Predicate<T>
        = object : Predicate<T> {

            public override fun apply(p0: T): Boolean {
                return body(p0)
            }
        }

fun gf<T>(body: (String) -> T): Function<String, T>
        = object : Function<String, T> {
            public override fun apply(p0: String): T {
                return body(p0)
            }
        }




