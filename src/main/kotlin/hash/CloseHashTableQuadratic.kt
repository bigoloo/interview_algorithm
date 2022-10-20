package hash


class CloseHashTableQuadratic<K, E> : AminHashTable<K, E> {

    data class Node<K, E>(val key: K, val data: E)

    private val _internal = arrayOfNulls<Node<K, E>>(10)
    override fun put(key: K, item: E) {
        val currentLocation = getKey(key)
        with(_internal) {
            getOrNull(currentLocation)?.let {
                if (it.key == key) {
                    set(currentLocation, it.copy(data = item))
                    return
                }
                var i = 1
                var nextLocation = getKey(key, 1)
                var nextValue = getOrNull(nextLocation)
                while (nextValue != null && i < 10 && nextValue.key != key) {
                    nextLocation = getKey(key, ++i)
                    nextValue = getOrNull(nextLocation)
                }

                if (nextValue == null || nextValue.key == key) {
                    set(currentLocation, Node(key, item))
                }/* else throw Exception("hash is Empty")*/
            } ?: run {
                set(currentLocation, Node(key, item))
            }
        }

    }

    private fun getKey(key: K, probIndex: Int = 0): Int {
        return (key.hashCode() + probIndex.times(probIndex)).mod(10)
    }

    override fun get(key: K): E? {
        with(_internal) {
            var i = 0
            var currentKey = getKey(key, 0)
            var currentValue = getOrNull(currentKey)
            while (currentValue != null && i < 10 && currentValue.key != key) {
                currentKey = getKey(key, ++i)
                currentValue = getOrNull(currentKey)
            }

            return if (currentValue != null && currentValue.key == key) currentValue.data
            else null
        }
    }
}

fun main() {

    val hashTable = CloseHashTableQuadratic<Int, String>()

    with(hashTable) {

        put(12, "soror")
        put(12, "salam")
        put(23, "eli")
        put(13, "amin")



        println(get(23))
        println(get(13))
        println(get(12))
        println(get(14))
        println(get(22))
        println(get(199999))
    }
}