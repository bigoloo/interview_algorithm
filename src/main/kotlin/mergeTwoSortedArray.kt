fun main() {

    val array1 = intArrayOf(2, 4, 5)
    val array2 = intArrayOf(4, 6,8,9,10)

    println(mergeTwoArray(array1, array2).toList().toString())
}

fun mergeTwoArray(array1: IntArray, array2: IntArray): IntArray {
    val mergedIntArray = IntArray(array1.size + array2.size)
    var i = 0
    var j = 0
    (0..mergedIntArray.lastIndex).forEach {
        if (array1.getOrElse(
                i
            ) {
                Int.MAX_VALUE
            } < array2.getOrElse(j) { Int.MAX_VALUE }
        ) {
            mergedIntArray[it] = array1[i]
            i++
        } else {
            mergedIntArray[it] = array2[j]
            j++
        }
    }
    return mergedIntArray
}
