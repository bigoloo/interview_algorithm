fun main() {
    val unsortedArray = intArrayOf(44, 23, 29, 15, 2, 4, 19, 31, 7, 9, 5)
    val sortedArray = mergeSortDesc(unsortedArray, 0, unsortedArray.lastIndex)
    println(sortedArray.toList().toString())
}

fun mergeSort(array: IntArray, firstIndex: Int, lastIndex: Int): IntArray {
    if (lastIndex - firstIndex < 1) return array
    val middleIndex = firstIndex + ((lastIndex - firstIndex) / 2)
    //left side
    mergeSort(array, firstIndex, middleIndex)
    //right side
    mergeSort(array, middleIndex + 1, lastIndex)
    //merge phase

    //val array1 = array.sliceArray(firstIndex..middleIndex)
    //val array2 = array.sliceArray(middleIndex + 1..lastIndex)
    //val tempArray = mergeTwoArray(array1, array2)
    var i = firstIndex
    var j = middleIndex + 1
    val tempArray = IntArray(lastIndex - firstIndex + 1)


    (0..tempArray.lastIndex).forEach {
        if (i <= middleIndex && j <= lastIndex) {
            if (array[i] < array[j]) {
                tempArray[it] = array[i]
                i++
            } else {
                tempArray[it] = array[j]
                j++
            }
        } else {
            if (i > middleIndex) {
                tempArray[it] = array[j]
                j++
            } else if (j > lastIndex) {
                tempArray[it] = array[i]
                i++
            }
            return@forEach
        }
    }
    var k = 0
    (firstIndex..lastIndex).forEach {
        array[it] = tempArray[k]
        k++
    }
    return array
}

fun mergeSortDesc(array: IntArray, firstIndex: Int, lastIndex: Int): IntArray {
    if (lastIndex - firstIndex < 1) return array
    val middleIndex = firstIndex + ((lastIndex - firstIndex) / 2)
    //left side
    mergeSortDesc(array, firstIndex, middleIndex)
    //right side
    mergeSortDesc(array, middleIndex + 1, lastIndex)
    //merge phase

    //val array1 = array.sliceArray(firstIndex..middleIndex)
    //val array2 = array.sliceArray(middleIndex + 1..lastIndex)
    //val tempArray = mergeTwoArray(array1, array2)
    var i = firstIndex
    var j = middleIndex + 1
    val tempArray = IntArray(lastIndex - firstIndex + 1)


    (0..tempArray.lastIndex).forEach {
        if (i <= middleIndex && j <= lastIndex) {
            if (array[i] > array[j]) {
                tempArray[it] = array[i]
                i++
            } else {
                tempArray[it] = array[j]
                j++
            }
        } else {
            if (i > middleIndex) {
                tempArray[it] = array[j]
                j++
            } else if (j > lastIndex) {
                tempArray[it] = array[i]
                i++
            }
            return@forEach
        }
    }
    var k = 0
    (firstIndex..lastIndex).forEach {
        array[it] = tempArray[k]
        k++
    }
    return array
}
