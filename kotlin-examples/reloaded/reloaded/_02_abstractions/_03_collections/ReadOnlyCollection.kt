package reloaded.abstractions.collections

import java.util.HashSet

class Person {
    private val friends = HashSet<Person>()

    public fun addFriend(friend: Person) {
        friends.add(friend)
        friend.friends.add(this)
    }

    public fun getFriends(): Collection<Person> = friends
}

fun main(args: Array<String>) {
    val jane = Person()
    val john = Person()

//    val friends: Collection<Person> = john.getFriends()
//    john.getFriends().add(jane)
//    john.getFriends().clear()

    printAll(john.getFriends())
}

fun printAll(objects: Collection<Any>) {
    for (obj in objects) {
        println(obj)
    }
}