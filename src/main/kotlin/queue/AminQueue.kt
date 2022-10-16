package queue

interface AminQueue<E> {
    fun offer(item: E)
    fun poll(): E
    fun isEmpty(): Boolean
    fun peak(): E?
}