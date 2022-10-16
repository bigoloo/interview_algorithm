package queue

class LInkedQueue<E> : AminQueue<E> {
    private class Node<E>(val data: E, var next: Node<E>?, var previous: Node<E>?)

    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    override fun offer(item: E) {
        val node = Node(data = item, null, null)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.previous = tail
            tail = node
        }
    }

    override fun poll(): E {
        if (isEmpty()) throw Exception("Queue is empty")
        else {
            return head?.data!!.also {
                head = head?.next
                head?.previous = null
            }
        }
    }

    override fun isEmpty(): Boolean {
        return head == null
    }

    override fun peak(): E? {
        return head?.data
    }
}
fun main() {

    val aminArrayQueue = LInkedQueue<Int>()
    with(aminArrayQueue) {
        offer(0)
        offer(10)
        offer(20)
        offer(30)
        offer(40)
        offer(50)
        offer(60)
        offer(70)
        offer(80)
        offer(90)
        offer(100)
        offer(110)
        poll()
        poll()
        offer(120)
        while (peak() != null) {
            print("${poll()},")
        }
    }
}