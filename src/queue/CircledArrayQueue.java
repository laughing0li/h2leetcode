package queue;
/**
 * 利用数组模拟环形队列，队列可以复用
 * front指向队列第一个元素
 * rear指向队列的最后一个元素的下一个位置。
 * 所以该环形队列会空出一个位置，最大容量为maxSize - 1
 */

public class CircledArrayQueue {
    private int maxSize; //队列最大容量
    private int front;  //队列头
    private int rear;   // 指向队列最后一个元素的下一个
    private int[] arr; //用于存放数据的数组，模拟队列

    public CircledArrayQueue(int size) {
        this.maxSize = size;
        this.arr = new int[size];
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int total() {
        return (rear + maxSize - front) % maxSize;
    }

    public void add(int num) {
        if (isFull()) {
            throw new RuntimeException("队列满！");
        }
        arr[rear] = num;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列空！");
        }
        int num = arr[front];
        // 向前移动一位。
        front = (front + 1) % maxSize;
        return num;
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int arrLen = total();
        // 因为是环形的，所以遍历的时候，应该从front开始
        for (int i = front; i < front + arrLen; i++) {
            // 在遍历的时候，i是不能超过maxSize的，所以需要对其取余
            System.out.println(arr[i % maxSize]);
        }
    }

}
