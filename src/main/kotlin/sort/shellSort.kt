fun main() {
    val unsortedArray = intArrayOf(44, 23, 29, 15, 2, 4, 19, 31, 7, 9, 5, 2)
    val sortedArray = shellSort(unsortedArray)
    println(sortedArray.toList().toString())
}

fun shellSort(array: IntArray): IntArray {
    var gap = array.size / 2
    while (gap > 0) {
        (0..array.size - gap).forEach { i ->
            (i downTo 0 step gap).forEach { j ->
                if (j - gap >= 0 && array[j] < array[j - gap]) {
                    val temp = array[j]
                    array[j] = array[j - gap]
                    array[j - gap] = temp
                }
            }
        }
        gap /= 2
    }
    return array
}
