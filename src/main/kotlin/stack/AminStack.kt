package stack

interface AminStack<E> {
    fun pop(): E?
    fun push(item: E)
    fun peak(): E?
    fun isEmpty(): Boolean
}