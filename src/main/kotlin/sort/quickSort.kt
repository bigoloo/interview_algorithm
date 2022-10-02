fun main() {
    val array = intArrayOf(10, 7, 12, 8, 3, 2, 6)

    quickSort(array, 0, array.lastIndex)
    println(array.toList().toString())
}


fun partition(array: IntArray, startIndex: Int, lastIndex: Int): Int {

    val pivot = array[lastIndex]
    var leftIndex = startIndex
    var rightIndex = startIndex

    while (rightIndex < lastIndex) {
        if (array[rightIndex] >= pivot) rightIndex++
        else {
            swap(array, rightIndex, leftIndex)
            leftIndex++
            rightIndex++
        }
    }
    swap(array, leftIndex, lastIndex)
    return leftIndex
}

fun partition2(array: IntArray, startIndex: Int, lastIndex: Int): Int {
    val pivot = array[startIndex]
    var leftIndex = startIndex + 1
    var rightIndex = startIndex + 1
    while (rightIndex <= lastIndex) {
        if (array[rightIndex] >= pivot) rightIndex++
        else {
            swap(array, rightIndex, leftIndex)
            leftIndex++
            rightIndex++
        }
    }

    swap(array, leftIndex - 1, startIndex)
    return leftIndex - 1
}

fun swap(array: IntArray, fromIndex: Int, toIndex: Int) {
    val temp = array[fromIndex]
    array[fromIndex] = array[toIndex]
    array[toIndex] = temp
}

fun quickSort(array: IntArray, startIndex: Int, lastIndex: Int) {
    if (lastIndex - startIndex < 1) return
    val pivotIndex = partition2(array, startIndex, lastIndex)
    quickSort(array, startIndex, pivotIndex - 1)
    quickSort(array, pivotIndex + 1, lastIndex)

}
