package subsequence

import java.util.ArrayList

operator fun String.get(range: ClosedRange<Int>): String {
    return substring(range.start, range.endInclusive + 1)
}

operator fun String.get(range: Pair<SequencePosition, SequencePosition>): String {
    return substring(
            range.first.toIndex(length),
            range.second.toIndex(length) + 1
    )
}

operator fun <T> List<T>.get(range: IntProgression): List<T> {
    if (range.step == 1) {
        return subList(range.first, range.last + 1)
    }
    val result = ArrayList<T>()
    for (i in range) {
        result.add(this[i])
    }
    return result
}

operator fun <T> List<T>.get(range: Pair<SequencePosition, SequencePosition>): List<T> {
    return subList(
            range.first.toIndex(size),
            range.second.toIndex(size) + 1
    )
}

interface SequencePosition {
    fun toIndex(size: Int): Int

    operator fun rangeTo(other: SequencePosition): Pair<SequencePosition, SequencePosition> {
        return Pair(this, other)
    }
}

class SequenceIndex(public val index: Int): SequencePosition {
    override fun toIndex(size: Int): Int = index
}

operator fun SequencePosition.rangeTo(index: Int): Pair<SequencePosition, SequencePosition> {
    return Pair(this, SequenceIndex(index))
}

operator fun Int.rangeTo(other: SequencePosition): Pair<SequencePosition, SequencePosition> {
    return Pair(SequenceIndex(this), other)
}

val FIRST: SequencePosition = SequenceIndex(0)
val LAST = object : SequencePosition {
    override fun toIndex(size: Int): Int = size - 1
}

operator fun SequencePosition.minus(delta: Int): SequencePosition
        = object : SequencePosition {
                override fun toIndex(size: Int): Int = this@minus.toIndex(size) - delta
            }