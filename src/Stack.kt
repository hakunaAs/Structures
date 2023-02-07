interface Stack<Int> {
    /**
     * Добавление элемента
     *
     */
    fun push(item: Int)

    /**
     * Удаление верхнего элемента стека
     *
     */
    fun pop() : Int

    /**
     * Узнать какой элемент наверху стека
     *
     */
    fun peek() : Int

    /**
     * Проверка на наличие элементов в стеке
     *
     */
    fun isEmpty() : Boolean

    /**
     * Очищает весь стек
     *
     */
    fun clear()

    class ArrayListStack: Stack<Int> {
        private val data = ArrayList<Int>()

        override fun push(item: Int) {
            data.add(item)
        }

        override fun pop() : Int {
            if (isEmpty()) {
                throw IllegalArgumentException("Стек пуст!")
            }
            return data.removeLast()
        }

        override fun peek() : Int {
            if (isEmpty()) {
                throw IllegalArgumentException("Стек пуст!")
            }
            return data.last()
        }

        override fun isEmpty() = data.isEmpty()

        override fun clear() {
            data.clear()
        }
    }
}