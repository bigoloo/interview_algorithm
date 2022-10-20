package hash

interface AminHashTable<K, E> {
    fun put(key: K, item: E)
    fun get(key: K): E?
}