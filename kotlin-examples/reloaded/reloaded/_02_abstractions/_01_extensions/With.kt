package reloaded.abstractions.extensions.with

fun main(args: Array<String>) {

    val stringBuilder = StringBuilder()

    stringBuilder.append("prefix")
    for (i in 1..10) {
        stringBuilder.append(i)
    }














    with0(stringBuilder, {
        b ->

        b.append("prefix")
        for (i in 1..10) {
            b.append(i)
        }


    })





    with(stringBuilder, fun StringBuilder.() {

        this.append("prefix")
        for (i in 1..10) {
            this.append(i)
        }


    })






    with(stringBuilder, {

        append("prefix")
        for (i in 1..10) {
            append(i)
        }


    })








    with (stringBuilder) {

        append("prefix")

        for (i in 1..10) {
            append(i)
        }

    }








}












fun <T> with0(t: T, body: (T) -> Unit) {
    body(t)
}

fun <T> with(t: T, body: T.() -> Unit) {
    t.body()
}

