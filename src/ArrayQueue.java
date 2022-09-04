/**
 * 使用数组模拟队列
 */

class ArrayQueue {
    private int maxSize; //队列最大容量
    private int front;  //队列头
    private int rear;   // 队列尾
    private int[] arr; //用于存放数据的数组，模拟队列

    // 构造器，初始化队列
    public ArrayQueue(int size) {
        maxSize = size;
        arr = new int[size];
        front = 0;
        rear = 0;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int num) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        arr[rear] = num;
        rear++;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        int num = arr[front];
        front++;
        return num;
    }

    public void display() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}


