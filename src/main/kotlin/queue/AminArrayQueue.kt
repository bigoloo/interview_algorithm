package queue

class AminArrayQueue<E>(size: Int = 10) : AminQueue<E> {

    private var _capacity = size
    private var _internalArray = Array<Any?>(10) {
        null
    } as Array<E?>

    private var _rear = -1
    override fun offer(item: E) {
        if (!hasCapacity()) grow()
        _internalArray[++_rear] = item
    }

    private fun grow() {
        _capacity *= 2
        _internalArray = Array<Any?>(_capacity * 2) {
            _internalArray.getOrNull(it)
        } as Array<E?>
    }

    private fun hasCapacity(): Boolean {
        return (_rear + 1) != _capacity
    }

    private fun shiftLeft() {
        _internalArray.forEachIndexed { index, e ->
            _internalArray[index] = _internalArray.getOrNull(index + 1)
        }
    }

    override fun poll(): E {
        return _internalArray[0]?.also {
            _rear--
            shiftLeft()
        } ?: throw IndexOutOfBoundsException("queue is empty")
    }

    override fun isEmpty(): Boolean {
        return 0 == _rear
    }

    override fun peak(): E? {
        return _internalArray.getOrNull(0)
    }
}

fun main() {

    val aminArrayQueue = AminArrayQueue<Int>()

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