/**
 * Двусвязный список
 */

class DoubleLinkedList(

    private var first: Node? = null,

    private var last: Node? = null
) {
    private var count: Int = 0

    class Node(
        private val value: Int,
        private var prev: Node? = null,
        private var next: Node? = null
    ) {

        fun changeNext(next: Node? = null) {
            this.next = next
        }

        fun changePrev(prev: Node? = null) {
            this.prev = prev
        }

        fun next() = next
        fun prev() = prev
        fun value() = value

        fun isOne() = prev == null && next == null
        fun isFirst() = prev == null
        fun isLast() = next == null
    }

    fun size() = count

    fun toList() : List<Int> {
        if (first == null) return listOf()

        val list = mutableListOf<Int>()
        var node = first
        while (node != null) {
            list.add(node.value())
            node = node.next()
        }
        return list
    }

    fun contains(value: Int) : Boolean {
        if (first == null) return false

        var node = first
        while (node != null) {
            if (node.value() == value) {
                return true
            }
            node = node.next()
        }
        return false
    }

    fun isEmpty() = first == null

    fun remove(value: Int) : Boolean {
        if (first == null) return false

        var node = first

        while (node != null) {
            if (node.value() == value) {
                if (node.isOne()) {
                    first = null
                    last = null
                } else if (node.isFirst()) {
                    val next = node.next()
                    next?.changePrev(null)
                    first = next
                } else if (node.isLast()) {
                    val prev = node.prev()
                    prev?.changeNext(null)
                    last = prev
                } else {
                    node.prev()?.changeNext(node.next())
                    node.next()?.changePrev(node.prev())
                }
                count--
                return true
            }
            node = node.next()
        }
        return false
    }

    fun add(index: Int, value: Int) : Boolean {

        if (first == null) return false

        var i = 0
        var node = first
        while (node != null) {
            if (i == index) {
                val newNode = Node(value)

                newNode.changePrev(node.prev())
                newNode.changeNext(node)

                node.prev()?.changeNext(newNode)
                node.changePrev(newNode)

                count++
                return true
            }
            i++
            node = node.next()
        }

        return false
    }

    fun add(value: Int) = addLast(value)

    fun addFirst(value: Int) {
        val firstNode = first
        first = if (firstNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            newNode.changeNext(firstNode)
            firstNode.changePrev(newNode)
            newNode
        }
        if (last == null) {
            last = first
        }
        count++
    }

    fun addLast(value: Int) {
        val lastNode = last
        last = if (lastNode == null) {
            Node(value)
        } else {
            val newNode = Node(value)
            lastNode.changeNext(newNode)
            newNode.changePrev(lastNode)
            newNode
        }
        if (first == null) {
            first = last
        }
        count++
    }

}