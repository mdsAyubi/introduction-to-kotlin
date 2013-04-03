package reloaded.abstractions.lambdas.lock

import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.Lock

fun main(args: Array<String>) {

    val lock = ReentrantLock()

    lock.lock();
    try {
        // Do some work
    }
    finally {
        lock.unlock()
    }









    guarded(lock, { /* do some work */ })








    guarded (lock) {

        // Do some work

    }


}




fun guarded(lock: Lock, work: () -> Unit) {
    lock.lock();
    try {
        work()
    }
    finally {
        lock.unlock()
    }
}