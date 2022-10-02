package sort

fun main() {
    val array = intArrayOf(-111, 323, 123, 42323, 2123, 5, 234234, 23511, 32)
    radixSort(array)
    println(array.toList().toString())
}

fun radixSort(array: IntArray) {
    val base = array.maxOrNull()!!.toString().count()

    (0..base).forEach {
        val countingArray = Array(10) {
            mutableListOf<Int>()
        }
        array.forEach { value ->
            val position = value.digitReverseAt(it)
            countingArray[position].add(value)
        }
        var i = 0
        countingArray.forEach { it ->
            it.forEach {
                array[i] = it
                i++
            }
        }
    }
}

private fun Int.digitReverseAt(position: Int): Int {
    return this.toString().reversed().getOrNull(position)?.digitToIntOrNull() ?: 0
}
