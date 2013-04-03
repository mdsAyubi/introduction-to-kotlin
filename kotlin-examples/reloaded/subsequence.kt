package subsequence

import java.util.ArrayList

fun String.get(range: Range<Int>): String {
    return substring(range.start, range.end + 1)
}

fun String.get(range: Pair<SequencePosition, SequencePosition>): String {
    return substring(
            range.first.toIndex(size),
            range.second.toIndex(size) + 1
    )
}

fun <T> List<T>.get(range: Progression<Int>): List<T> {
    if (range.increment == 1) {
        return subList(range.start, range.end + 1)
    }
    val result = ArrayList<T>()
    for (i in range) {
        result.add(this[i])
    }
    return result
}

fun <T> List<T>.get(range: Pair<SequencePosition, SequencePosition>): List<T> {
    return subList(
            range.first.toIndex(size),
            range.second.toIndex(size) + 1
    )
}

trait SequencePosition {
    fun toIndex(size: Int): Int

    fun rangeTo(other: SequencePosition): Pair<SequencePosition, SequencePosition> {
        return Pair(this, other)
    }
}

class SequenceIndex(public val index: Int): SequencePosition {
    override fun toIndex(size: Int): Int = index
}

fun SequencePosition.rangeTo(index: Int): Pair<SequencePosition, SequencePosition> {
    return Pair(this, SequenceIndex(index))
}

fun Int.rangeTo(other: SequencePosition): Pair<SequencePosition, SequencePosition> {
    return Pair(SequenceIndex(this), other)
}

val FIRST: SequencePosition = SequenceIndex(0)
val LAST = object : SequencePosition {
    override fun toIndex(size: Int): Int = size - 1
}

fun SequencePosition.minus(delta: Int): SequencePosition
        = object : SequencePosition {
                override fun toIndex(size: Int): Int {
                    this@minus.toIndex(size) - delta
                }
            }