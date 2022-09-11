package stack;

/**
 * 利用数组来模拟栈
 */

public class StackArray {
        private int maxSize; // 栈的大小
        private int[] stack; // 用于实现栈的数组
        private int top = -1; // 表示栈顶，初始为-1

        public StackArray(){}

        public StackArray(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[maxSize];
        }

        public boolean isFull() {
            return top == maxSize - 1;
        } 

        public boolean isEmpty() {
            return top == -1;   
        }

        public void push(int num) {
            if (isFull()) {
                throw new RuntimeException("stack is full!");
            }
            top++;
            stack[top] = num;
        }

        public int pop() {
            if (isEmpty()) {
                throw new RuntimeException("stack is Empty!");
            }
            int res = stack[top];
            top--;
            return res;
        }

        // top最好只由添加或者删除来操作，其他的时候不要动
        public void list() {
            if (isEmpty()) {
                throw new RuntimeException("stack is Empty!");
            }
            int temp = top;
            while (true) {
                if (temp == -1) {
                    break;
                }
                System.out.println(stack[temp]);
                temp--;
            }
        }
        // top最好只由添加或者删除来操作，其他的时候不要动
        public int count() {
            int count = 0;
            int temp = top;
            while(true) {
                if(temp == -1) {
                    break;
                }
                temp--;
                count++;
            }
            return count;
        }

        public int peek() {
            return stack[top];
        }
}
