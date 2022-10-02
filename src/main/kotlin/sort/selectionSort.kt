fun main() {
    val unsortedArray = intArrayOf(44, 23, 29, 15, 2, 4, 19, 31, 7, 9, 5, 2)
    val sortedArray = selectionSort(unsortedArray)
    println(sortedArray.toList().toString())
}

fun selectionSort(unsortedArray: IntArray): IntArray {
    (unsortedArray.lastIndex downTo 0).forEach { i ->
        var largestIndex = 0
        (1..i).forEach { j ->
            if (unsortedArray[j] > unsortedArray[largestIndex]) largestIndex = j
        }
        val temp = unsortedArray[i]
        unsortedArray[i]= unsortedArray[largestIndex]
        unsortedArray[largestIndex] = temp
    }
    return unsortedArray
}
