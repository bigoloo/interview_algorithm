fun main() {
    val unsortedArray = intArrayOf(44, 23, 29, 15, 2, 4, 19, 31, 7, 9, 5, 2)
    val sortedArray = bubbleSort(unsortedArray)
    println(sortedArray.toList().toString())
}

fun bubbleSort(array: IntArray): IntArray {
    (array.lastIndex - 1 downTo 0 ).forEach { i ->
        (0..i).forEach { j ->
            if (array[j] > array[j + 1]) {
                val temp = array[j]
                array[j] = array[j + 1]
                array[j + 1] = temp
            }
        }
    }
    return array
}
