package search

fun main() {
    val arrayList = arrayListOf(-1, 2, 3, 4, 5, 777, 7777777,11111)


    println(search(arrayList, 23))
    println(search(arrayList, 4))

}

fun search(arrayList: ArrayList<Int>, value: Int): Int? {
    return binarySearch(arrayList, value, 0, arrayList.lastIndex)
}

fun binarySearch(arrayList: ArrayList<Int>, value: Int, firstIndex: Int, lastIndex: Int): Int? {

    if (lastIndex == firstIndex) {
        return if (value == arrayList[firstIndex]) value
        else null
    }
    val midIndex = (lastIndex - firstIndex) / 2 + firstIndex //always add firstIndex to midItem
    val midItem = arrayList[midIndex]
    return if (midItem == value) value
    else if (midItem > value) binarySearch(arrayList, value, firstIndex, midIndex - 1)
    else binarySearch(arrayList, value, midIndex + 1, lastIndex)
}

