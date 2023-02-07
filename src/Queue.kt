/** ������ ����� ������ �����**/
interface Queue<Int> {

    /**
     * ���������� ��������
     */
    fun offer(item: Int)

    /**
     * ������� ������� �� ������ �������
     */
    fun element(): Int

    /**
     * ���������� ������� �� ������ �������
     *
     *  � ������������ null
     */
    fun peek(): Int?

    /**
     * ������� ������� ������� �������
     */
    fun remove(): Int

    /**
     * �������� �������� �� ������ ������� � ���������� null
     */
    fun poll(): Int?

    /**
     * �������� �� ������� ��������� � �������
     *
     */
    fun isEmpty(): Boolean

    /**
     * ������� �������
     *
     */
    fun clear()

    /**
     * ������� ������� � ��������
     */
    fun remove(item: Int): Boolean

    class ArrayListQueue : Queue<Int> {
        private val data = ArrayList<Int>()

        override fun offer(item: Int) = data.add(0, item)

        override fun isEmpty() = data.isEmpty()
        override fun clear() = data.clear()

        override fun element() =
            if (isEmpty()) thr("������� �����!") else data.first()
        override fun peek() =
            if (isEmpty()) null else data.first()

        override fun remove() =
            if (isEmpty()) thr("������� �����!") else data.removeFirst()
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