package stack;
/**
 * 中缀表达式计算器
 */
public class Calculator extends StackArray{

    public Calculator(int maxSize) {
        super(maxSize);
    }

    // 运算符的优先顺序
    public static int priority(int operation) {
        if (operation == 42 || operation == 47) {
            return 1;
        } else {
            return 0;
        }
    }
    /**
     * + 43
     * - 45
     * * 42
     * / 47
     */
    public boolean isOperation(int operation) {
        return operation == 42 || operation == 43 || operation == 45 || operation == 47;
    }

    /**
     * 举例"4*3*2+3-6+6*5/2" 
     * 在将数据存放到栈中的时候是按照，从后往前放的顺序
     * 所以在栈顶是从4开始的。
     * @param num1
     * @param num2
     * @param operator
     * @return 返回计算结果
     */
    public static int cal(int num1, int num2, int operator) {
        int result = 0;
        switch (operator) {
            case 42:
                result = num1 * num2;
                break;
            case 47:
                result = num1 / num2;
                break;
            case 43:
                result = num1 + num2;
                break;
            case 45:
                result = num1 - num2;
                break;
            default:
                break;
        }
        return result;
    }


    public static int mockCal(char[] temp, Calculator num, Calculator oper) {
        // 用于接收数字
        String s = "";
        // 从字符组的最后一个开始往前遍历
        for (int i = temp.length - 1; i >=0; i--) {
            if (Character.isDigit(temp[i])) {
                // 这个时候组成的数字是反的，比如15会变成51，所以需要反转
                s += temp[i];
            } else {
                oper.push(temp[i]);
                // 当碰到运算符的时候，就要将s先反转然后换成数字存放到numstack
                s = new StringBuffer(s).reverse().toString();
                num.push(Integer.parseInt(s));
                // 然后初始化s
                s = "";
            }
            // 这里我们必须要考虑最后一个运算符后面的数字的情况。
            // 当遇到最后一个运算符，上面的if else是不会将该运算符后面的数字加入到栈中
            if (i == 0) {
                // 同样是需要将字符进行反转处理
                s = new StringBuffer(s).reverse().toString();
                num.push(Integer.parseInt(s));
            }
        }
        
        while (true) {
            if (oper.count() == 1) {
                int n1 = num.pop();
                int n2 = num.pop();
                int res = Calculator.cal(n1, n2, oper.pop());
                num.push(res);
                break;
            }
            int oper1 = oper.pop();
            if (priority(oper1) < priority(oper.peek())) {
                int n1 = num.pop();
                int n2 = num.pop();
                int n3 = num.pop();
                int res = cal(n2, n3, oper.pop());
                num.push(res);
                num.push(n1);
                oper.push(oper1);
            } else {
                int n1 = num.pop();
                int n2 = num.pop();
                int res = cal(n1, n2, oper1);
                num.push(res);
            }
        }
        
        return num.pop();
    }

}
