package collection

class DoublyLinkList<E>(node: Node<E>? = null) : AminList<E> {
    class Node<E>(var previous: Node<E>?, val data: E, var next: Node<E>?)

    var head: Node<E>? = null
    var tail: Node<E>? = null
    private var _size = 0

    init {

        if (node != null) {
            head = node
            _size++
            var cursor = node
            while (cursor?.next != null) {
                cursor = cursor.next
                _size++
            }
            tail = cursor
        }


    }

    override fun size(): Int {
        var size = 0
        var cursor = head
        while (cursor?.next != null) {
            cursor = cursor.next
            size++
        }
        _size = 0
        return size
    }

    override val lastIndex: Int
        get() = TODO("Not yet implemented")

    override fun remove(index: Int) {
        if (index == 0) {
            val nextHead = head?.next
            head?.next?.previous = null
            head?.next = null
            head = nextHead
        } else {
            var cursor = head
            repeat((0 until index).count()) {
                cursor = cursor?.next
            }
            if (cursor != null) {
                cursor?.previous?.next = cursor?.next
                cursor?.previous?.next?.previous = cursor?.previous
                cursor?.previous = null
            }
        }
    }

    override fun get(index: Int): E? {
        var cursor = head
        repeat((0 until index).count()) {
            cursor = cursor?.next
        }
        return cursor?.data
    }

    override fun add(item: E) {
        val node = Node(previous = null, next = null, data = item)
        if (head == null) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.previous = tail
            tail = node
        }
    }

    fun addFirst(item: E) {
        val node = Node(previous = null, item, next = head)
        head?.previous = node
        head = node
    }

    fun print() {
        println()
        var cursor = head
        while (cursor?.next != null) {
            print("${cursor.data},")
            cursor = cursor.next
        }
        print(cursor?.data)
    }

    fun revert() {
        var cursor = head
        while (cursor != null) {
            val nextNode = cursor.next
            val temp = cursor.next
            cursor.next = cursor.previous
            cursor.previous = temp
            cursor = nextNode
        }
        val temp = head
        head = tail
        tail = temp
    }

    fun revertRecursive() {
        revertR(head)
        val temp = head
        head = tail
        tail = temp
    }

    private tailrec fun revertR(node: Node<E>?) {
        if (node == null) return
        val nextNode = node.next
        val temp = node.next
        node.next = node.previous
        node.previous = temp
        revertR(nextNode)
    }
}

fun main() {
    val linkList = DoublyLinkList<Int>()
    with(linkList) {
        add(0)
        add(1)
        add(2)
        add(3)
        add(4)
        add(5)
        add(6)
        add(7)
        add(8)
        addFirst(-1)
        println("get index:${get(8)}")
        remove(1)
        println("get index:${get(8)}")
        print()
        revert()
        print()
        revertRecursive()
        print()
    }

}