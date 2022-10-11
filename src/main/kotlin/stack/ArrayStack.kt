package stack


class ArrayStack<E> : AminStack<E> {

    private val capacity = 10

    @Suppress("UNCHECKED_CAST")
    private var _internalArray: Array<E?> = arrayOfNulls<Any?>(capacity) as Array<E?>

    private var _top = -1
    override fun pop(): E? {
        if (_top < 0) return null
        return _internalArray.getOrNull(_top).also {
            _top--
        }
    }

    override fun peak(): E? {
        if (_top < 0) return null
        return _internalArray.getOrNull(_top)
    }

    override fun isEmpty(): Boolean {
        return _top == -1
    }

    override fun push(item: E) {

        if (!hasCapacity()) grow()
        _top++
        _internalArray[_top] = item

    }

    private fun grow() {
        val tempArray = arrayOfNulls<Any?>(capacity + _internalArray.size) as Array<E?>

        _internalArray.forEachIndexed { index, e ->
            tempArray[index] = e
        }
        _internalArray = tempArray
    }

    private fun hasCapacity(): Boolean {
        return _top + 1 < _internalArray.lastIndex
    }
}

fun main() {
    val aminStack = ArrayStack<Int>()

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

        while (peak() != null) {
            print("${pop()},")
        }
    }
}