interface Stack<Int> {
    /**
     * ���������� ��������
     *
     */
    fun push(item: Int)

    /**
     * �������� �������� �������� �����
     *
     */
    fun pop() : Int

    /**
     * ������ ����� ������� ������� �����
     *
     */
    fun peek() : Int

    /**
     * �������� �� ������� ��������� � �����
     *
     */
    fun isEmpty() : Boolean

    /**
     * ������� ���� ����
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
                throw IllegalArgumentException("���� ����!")
            }
            return data.removeLast()
        }

        override fun peek() : Int {
            if (isEmpty()) {
                throw IllegalArgumentException("���� ����!")
            }
            return data.last()
        }

        override fun isEmpty() = data.isEmpty()

        override fun clear() {
            data.clear()
        }
    }
}