import kotlin.math.abs

fun main() {
    val array = intArrayOf(-10000, 1, 1, 0, -1, -2,100)
    countingSort2(array)
    println(array.toList().toString())
}

fun countingSort(array: IntArray) {
    val max = array.maxOrNull()!!
    val countingArray = IntArray(max + 1)

    array.forEach { value ->
        countingArray[value] = countingArray.getOrNull(value)?.let {
            it + 1
        } ?: 1
    }
    var i = 0
    countingArray.forEachIndexed { index, value ->
        if (value != 0) {
            (0 until value).forEach { _ ->
                array[i] = index
                i++
            }
        }
    }
}

fun countingSort2(array: IntArray) {
    val max = array.maxOrNull()!!
    val min = array.minOrNull()!!
    val countingArray = IntArray(abs(min) + abs(max) + 1)

    array.forEach { value ->
        countingArray[value - min] = countingArray.getOrNull(value)?.let {
            it + 1
        } ?: 1
    }
    var i = 0
    countingArray.forEachIndexed { index, value ->
        if (value != 0) {
            (0 until value).forEach { _ ->
                array[i] = min + index
                i++
            }
        }
    }
}



