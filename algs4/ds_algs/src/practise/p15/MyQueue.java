package practise.p15;

import java.util.Queue;
import java.util.Scanner;

/**
 * @Auther: AJun
 * @version:1.0
 * @Date: 2020/08/22  21:34
 * @Description:队列
 */
public class MyQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyQueue() {
    }

    public MyQueue(int size) {
        this.data = new int[size];
        this.head = -1;
        this.tail = -1;
        this.size = size;
    }

    /**
     * 判断队列是否为空
     */
    public Boolean isEmpty() {
        return head == -1;
    }

    /**
     * 判断队列是否已满
     * 1. 头指针在起点 ，尾指针在终点
     * 2. 尾指针再头指针后面
     */
    public Boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    /**
     * 入队
     * 成功返回true
     */
    public Boolean enQueue(int value) {
        if (isFull()) {
            System.out.println("队列已满！！！");
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /**
     * 取出队首
     */
    public int getHead() {
        if (isEmpty() == true) {
            throw new RuntimeException("队列为空，无数据！！！");
        }
        int res = data[head];
        if (head == tail) {
            head = -1;
            tail = -1;
            return res;
        }
        head = (head + 1) % size;
        return res;
    }

    /**
     * 查看队首
     */
    public int Front() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[head];
    }

    /**
     * 查看队尾
     */
    public int Rear() {
        if (isEmpty() == true) {
            return -1;
        }
        return data[tail];
    }

    /**
     * 查看队列元素
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("该队列为空！！！");
            return;
        }
        for (int i = head; i < head + ((tail + size - head) % size) + 1; i++) {
            System.out.print(data[i] + "<-");
        }
        System.out.println();
    }

    /**
     * 查看队列元素个数
     */
    public int crrSize() {
        if (isEmpty()) return -1;
        return ((tail + size - head) % size) + 1;
    }
}

class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Boolean flag = true;
        MyQueue queue = new MyQueue(4);
        int x = -1;
        while (flag) {
            System.out.println("1:判断是否为空," + "2:判断是否已满," + "3：添加," + "4：取出," + "5：查看头," + "6：查看尾," + "7：查看队列," + "8：当前数量," + "0：退出。");
            x=scanner.nextInt();
            switch (x) {
                case 1:
                    System.out.println(queue.isEmpty());
                    break;
                case 2:
                    System.out.println(queue.isFull());
                    break;
                case 3:
                    System.out.print("请输出值：");
                    int value=scanner.nextInt();
                    queue.enQueue(value);
                    break;
                case 4:
                    System.out.println(queue.getHead());
                    break;
                case 5:
                    System.out.println(queue.Front());
                    break;
                case 6:
                    System.out.println(queue.Rear());
                    break;
                case 7:
                    queue.showQueue();
                    break;
                case 8:
                    System.out.println(queue.crrSize());
                    break;
                case 0:
                    flag = false;
                    break;
            }

        }
        System.out.println("---------正在退出--------");
    }
}