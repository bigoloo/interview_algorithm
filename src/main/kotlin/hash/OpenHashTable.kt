package hash

/**
 * This HashTable uses Chain Method for storing data
 *
 */
class OpenHashTable<K, E> : AminHashTable<K, E> {

    data class Node<K, E>(val key: K, var data: E, var next: Node<K, E>?)

    private val arrayList = arrayOfNulls<Node<K, E>?>(10)

    override fun put(key: K, item: E) {
        val tempNode = Node(key, item, null)
        val newKey = getKey(key)
        arrayList.getOrNull(newKey)?.let {
            if (it.key == key) {
                it.data = item
                return
            }
            var cursor: Node<K, E>? = it
            while (cursor?.next != null && cursor.key != key) cursor = cursor.next
            if (cursor?.next == null) cursor?.next = tempNode
            else cursor.data = item

        } ?: run {
            arrayList[newKey] = tempNode
        }
    }

    private fun getKey(item: K): Int {
        return item.hashCode().mod(10)
    }

    override fun get(key: K): E? {
        return arrayList.getOrNull(getKey(key))?.let {
            if (it.key == key) it.data
            else {
                var cursor: Node<K, E>? = it
                while (cursor != null) {
                    if (cursor.key == key) return@let cursor.data
                    else cursor = cursor.next
                }
                null
            }
        }
    }
}

fun main() {

    val hashTable = OpenHashTable<Int, String>()

    with(hashTable) {

        put(12, "soror")
        put(13, "amin")
        put(14, "akbar")
        put(15, "asghar")
        put(16, "123234")
        put(22, "tina")
        put(23, "eli")
        put(12, "salam")

        println(get(23))
        println(get(13))
        println(get(12))
        println(get(14))
        println(get(22))
        println(get(199999))

    }
}