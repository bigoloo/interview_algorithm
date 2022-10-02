package collection

fun main() {
    val array = arrayListOf<Int>()
    val intArray = IntArray(2) {
        -1
    }
    println(intArray.lastIndex)
}

interface AminList<E> {
    fun size():Int
    val lastIndex: Int
    fun add(item: E)
    fun remove(index: Int)
    fun get(index: Int): E?

}