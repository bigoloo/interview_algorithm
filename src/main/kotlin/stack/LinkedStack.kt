package stack

class LinkedStack<E> : AminStack<E> {

    private data class Node<E>(val data: E, val prevous: Node<E>? = null)

    private var top: Node<E>? = null
    override fun pop(): E? {
        if (isEmpty()) return null
        var temp = top?.prevous
        return top?.data.also {
            top = temp
        }
    }

    override fun peak(): E? {
        return top?.data
    }

    override fun isEmpty(): Boolean {
        return top == null
    }

    override fun push(item: E) {
        top = Node<E>(item, top)
    }
}

fun main() {

    val aminStack = LinkedStack<Int>()

    with(aminStack) {
        push(0)
        push(1)
        push(2)
        push(3)
        push(4)
        push(5)
        push(6)
        push(7)
        pop()
        push(8)
        push(9)
        push(10)
        push(11)
        push(12)
        push(13)

       // println("is empty : ${isEmpty()}/ peak is :${peak()}/pop: ${pop()}")
        while (peak() != null) {
            print("${pop()},")
        }
    }
}