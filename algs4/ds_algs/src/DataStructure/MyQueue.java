package DataStructure;



/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/29  15:39
 * @Description: 以数组构建的队列 ，链表的话需要一个头节点和当前节点
 */
public class MyQueue {

    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    /** 将元素插入循环队列。如果操作成功，则返回true */
    public boolean enQueue(int value) {
        if (isFull() == true) {
            return false;
        }
        if (isEmpty() == true) {
            head = 0;
        }
        //通过取模让指针循环
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /** 从循环队列中删除一个元素。如果操作成功，则返回true */
    public boolean deQueue() {
        if (isEmpty() == true) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    /**从队列中获取最前面的元素 */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    /** 从队列中获取最后一个元素。 */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    /** 检查循环队列是否为空 */
    public boolean isEmpty() {
        return head == -1;
    }

    /** 检查循环队列是否已满。 */
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    public static void main(String[] args) {
        MyQueue circularQueue = new MyQueue(3); // 设置长度为 3
        System.out.println(circularQueue.enQueue(1));
        System.out.println(circularQueue.enQueue(2));
        System.out.println(circularQueue.Rear());
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue.enQueue(4));
        System.out.println(circularQueue.Rear());

    }
}
