package hash


class CloseHashTableLinear<K, E> : AminHashTable<K, E> {

    data class Node<K, E>(val key: K, val data: E)

    private val _internalArray = arrayOfNulls<Node<K, E>?>(10)

    override fun put(key: K, item: E) {
        val firstLocation = getKey(key)
        with(_internalArray) {
            getOrNull(firstLocation)?.let {
                if (key == it.key) {
                    set(firstLocation, Node(key, item))
                    return
                }
                var nextAvailableLocation = (firstLocation + 1).mod(10)
                while (getOrNull(nextAvailableLocation) != null && nextAvailableLocation != firstLocation) {
                    nextAvailableLocation = (nextAvailableLocation + 1).mod(
                        10
                    )
                }


                if (getOrNull(nextAvailableLocation) != null) throw Exception("hashtable is full")
                else set(nextAvailableLocation, Node(key, item))
            } ?: run {
                set(firstLocation, Node(key, item))
            }
        }
    }

    private fun getKey(key: K): Int {
        return key.hashCode().mod(10)
    }

    override fun get(key: K): E? {
        with(_internalArray) {
            val firstLocation = getKey(key)
            return getOrNull(firstLocation)?.let {
                if (it.key == key) return@let it.data
                else {
                    var cursor = (firstLocation + 1).mod(10)
                    while (getOrNull(cursor) != null && cursor != firstLocation) {
                        if (getOrNull(cursor)!!.key == key) return@let getOrNull(cursor)?.data
                        cursor++
                    }
                    return@let getOrNull(cursor)?.takeIf {
                        it.key == key
                    }?.data
                }
            }
        }
    }
}

fun main() {

    val hashTable = CloseHashTableLinear<Int, String>()

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