package collection

class AminArrayList<E>(private val capacity: Int = 10) : AminList<E> {
    override fun size(): Int {
        return _lastIndex + 1
    }

    private var currentCapacity = capacity

    override val lastIndex: Int
        get() = internalList.lastIndex


    private var _lastIndex = -1
    private var internalList = Array<Any?>(capacity) {
        null
    }

    override fun add(item: E) {
        if (!hasSpace()) grow()
        internalList[++_lastIndex] = item as Any
    }

    private fun grow() {
        currentCapacity *= 2
        val tempList = Array<Any?>(currentCapacity) {
            if (it <= internalList.lastIndex) internalList[it]
            else null
        }
        internalList = tempList
    }

    private fun hasSpace(): Boolean {
        return (_lastIndex < internalList.lastIndex)
    }

    override fun remove(index: Int) {

        (index.._lastIndex).forEach {
            internalList[it] = internalList[it + 1]
        }
        _lastIndex -= 1
    }

    override operator fun get(index: Int): E? {
        return internalList[index] as? E
    }
}

fun main() {
    val aminArray = AminArrayList<Int>()
    aminArray.add(0)
    aminArray.add(1)
    aminArray.add(2)
    aminArray.add(3)
    aminArray.add(4)
    aminArray.add(5)
    aminArray.add(6)
    aminArray.add(7)
    aminArray.add(8)
    aminArray.add(9)
    aminArray.add(10)
    aminArray.add(1)
    aminArray.add(2)

    println("size:"+aminArray.size())
    aminArray.remove(7)
    aminArray.add(3)
    aminArray.remove(aminArray.lastIndex)
    aminArray.add(4)
    println("size:"+aminArray.size())

    (0..aminArray.lastIndex).forEach {
        println(aminArray[it])
    }
}