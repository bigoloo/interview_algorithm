package collection


class AminLinkList<E> : AminList<E> {


    data class Node<E>(
        var data: E? = null, var nextNode: Node<E>? = null
    )


    var head: Node<E>? = null


    override fun size(): Int {
        if (head == null) return 0
        var lenght = 1
        var cursor = head

        while (cursor?.nextNode != null) {
            lenght++
            cursor = cursor.nextNode
        }
        return lenght
    }

    override val lastIndex: Int
        get() = TODO("Not yet implemented")

    override fun remove(index: Int) {
        if (index == 0) {
            val nextHead = head?.nextNode
            head?.nextNode = null
            head = nextHead
            return
        }
        var cursor = head
        for (index in 1 until index) {
            cursor = cursor?.nextNode
        }
        val nextAfterRemote = cursor?.nextNode?.nextNode
        cursor?.nextNode?.nextNode = null
        cursor?.nextNode = nextAfterRemote
    }

    override fun add(item: E) {
        if (size() == 0) {
            head = Node<E>(item, null)
            return
        }
        var tempNode: Node<E>? = head
        while (tempNode?.nextNode != null) {
            tempNode = tempNode.nextNode
        }
        tempNode!!.nextNode = Node(item, null)
    }

    fun print() {
        var cursor = head
        while (cursor?.nextNode != null) {
            print("${cursor.data},")
            cursor = cursor.nextNode
        }
        print(cursor!!.data)
    }

    fun reverse() {
        if (head?.nextNode == null) return

        var prev: Node<E>? = null
        var current = head
        var next = current?.nextNode

        while (current != null) {
            current.nextNode = prev
            prev = current
            current = next
            next = next?.nextNode
        }
        head = prev
    }

    fun reverseRecursive() {
        val prev: Node<E>? = null
        val current = head
        val next = current?.nextNode
        reverseR(prev, current, next)

    }

    fun hasLoop(): Boolean {
        val visitedNodes = hashSetOf<Int>()
        visitedNodes.add(head.hashCode())
        var cursor = head
        while (cursor?.nextNode != null) {
            if (visitedNodes.contains(cursor.nextNode.hashCode())) return true
            visitedNodes.add(cursor.nextNode.hashCode())
            cursor = cursor.nextNode

        }
        return false
    }

    private fun reverseR(prev: Node<E>?, current: Node<E>?, next: Node<E>?) {
        if (current == null) {
            head = prev
            return
        }
        current.nextNode = prev
        reverseR(current, next, next?.nextNode)

    }

    override fun get(index: Int): E {
        var cursor = 0
        var tempNode = head
        while (cursor < index) {
            tempNode = tempNode!!.nextNode
            cursor++
        }
        return tempNode!!.data!!
    }
}

fun main() {

    val list = AminLinkList<Int>()
    list.add(0)
    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)
    list.add(6)
    list.add(7)
    list.add(8)
    println(list.size())


    list.print()
    println()
    list.reverse()
    println()
    list.print()
    list.reverseRecursive()

    println("\nrecursive:")
    list.print()

    println("\nhas loop: ${list.hasLoop()}")

}