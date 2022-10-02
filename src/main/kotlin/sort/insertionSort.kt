fun main() {
    val unsortedArray = intArrayOf(44, 23, 29, 15, 2, 4, 19, 31, 7, 9, 5, 2)
    val sortedArray = insertionSort(unsortedArray)
    println("insertionSort " + sortedArray.toList().toString())
}

fun insertionSort(array: IntArray): IntArray {
    (1..array.lastIndex).forEach { i ->
        (i downTo 1).forEach { j ->
            if (array[j] < array[j - 1]) {
                val temp = array[j]
                array[j] = array[j - 1]
                array[j - 1] = temp
            }
        }

    }
    return array
}
