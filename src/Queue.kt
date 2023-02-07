/** Первый вошел первый вышел**/
interface Queue<Int> {

    /**
     * Добавление элемента
     */
    fun offer(item: Int)

    /**
     * Вернуть элемент из начала очереди
     */
    fun element(): Int

    /**
     * Возвращает элемент из начала очереди
     *
     *  с возможностью null
     */
    fun peek(): Int?

    /**
     * Удаляет элемент вначале очереди
     */
    fun remove(): Int

    /**
     * Удаление элемента из начала очереди с поддержкой null
     */
    fun poll(): Int?

    /**
     * Проверка на наличие элементов в очереди
     *
     */
    fun isEmpty(): Boolean

    /**
     * Очищает очередь
     *
     */
    fun clear()

    /**
     * Удаляет элемент в середине
     */
    fun remove(item: Int): Boolean

    class ArrayListQueue : Queue<Int> {
        private val data = ArrayList<Int>()

        override fun offer(item: Int) = data.add(0, item)

        override fun isEmpty() = data.isEmpty()
        override fun clear() = data.clear()

        override fun element() =
            if (isEmpty()) thr("Очередь пуста!") else data.first()
        override fun peek() =
            if (isEmpty()) null else data.first()

        override fun remove() =
            if (isEmpty()) thr("Очередь пуста!") else data.removeFirst()
        override fun poll() =
            if (isEmpty()) null else data.removeFirst()

        override fun remove(item: Int): Boolean {
            return if (data.contains(item)) {
                data.remove(item)
                true
            } else {
                false
            }
        }

        private fun thr(msg: String): Nothing {
            throw IllegalStateException(msg)
        }
    }
}