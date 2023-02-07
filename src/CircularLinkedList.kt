/**
 *Циклический список
 */

class CircularLinkedList(

    private var first: Node? = null,

    private var last: Node? = null,
) {

    private var count: Int = 0

    class Node(
        private val value: Int,
        private var next: Node? = null
    ) {

        fun changeNext(next: Node? = null) {
            this.next = next
        }

        fun next() = next
        fun value() = value
    }

    fun size() = count

    fun isCircular() = last?.next()?.value() == first?.value()

    fun toList() : List<Int> {
        if (first == null) return listOf()

        val list = mutableListOf<Int>()
        var node = first
        for (i in 0 until count) {
            if (node != null) {
                list.add(node.value())
            }
            node = node?.next()
        }

        return list
    }

    fun contains(value: Int) : Boolean {
        if (first == null) return false

        var node = first
        for (i in 0 until count) {
            if (node?.value() == value) {
                return true
            }
            node = node?.next()
        }

        return false
    }

    fun isEmpty() = first == null

    fun remove(value: Int) : Boolean {
        if (first == null) {
            return false
        }

        var prev = first
        var node = first

        for (i in 0 until count) {
            if (node?.value() == value) {
                if (prev?.value() == node?.value()) {
                    this.first = null
                    this.last = null
                } else {
                    prev?.changeNext(node?.next())
                }
                this.last?.changeNext(this.first)
                count--
                return true
            }
            prev = node
            node = node?.next()
        }
        return false
    }

    fun add(index: Int, value: Int) : Boolean {

        if (first == null) return false

        var node = first

        for (i in 0 until count - 1) {
            if (i == index) {
                val newNode = Node(value)
                node?.changeNext(newNode)
                this.last?.changeNext(this.first)
                count++
                return true
            }
            node = node?.next()
        }

        return false
    }

    fun add(value: Int) = addLast(value)

    fun addFirst(value: Int) {
        val node = Node(value)
        if (first == null) {
            this.first = node
            this.last = node
        } else {
            node.changeNext(first)
            this.first = node
        }
        this.last?.changeNext(this.first)
        count++
    }

    fun addLast(value: Int) {
        val newNode = Node(value)
        if (first == null) {
            this.first = newNode
            this.last = newNode
        } else {
            this.last?.changeNext(newNode)
            this.last = newNode
        }
        this.last?.changeNext(this.first)
        count++
    }

}