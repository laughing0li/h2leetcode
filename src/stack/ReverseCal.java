package stack;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseCal extends Calculator{

    public ReverseCal(int maxSize) {
        super(maxSize);
    }

    public static int priority(String oper) {
        if (oper.equals("*") || oper.equals("/")) {
            return 1;
        } else {
            return 0;
        }
    }

    public ArrayList<String> stringToList(String experission) {
        char[] temp = experission.toCharArray();
        ArrayList<String> aList = new ArrayList<>();
        String num = "";
        int i = 0;
        while (true) {
            if (i == temp.length) {
                // 当剩余最后一个数字的时候，需要将数字手动push到数组
                aList.add(num);
                break;
            }
            // 判断每一个字符，是否是数字
            if (Character.isDigit(temp[i])) {
                // 数字就放入num并且如果是连续的数字，那么持续放入
                num += temp[i];
            } else {
                // 当时运算符的时候，且num不为空，就将数字先push到数组
                if (num != "") {
                    aList.add(num);
                }
                // 这个时候也将运算符先转换成string然后添加到数组
                aList.add(String.valueOf(temp[i]));
                // 清空数组
                num = "";
            }
            i++;
        }
        return aList;
    }

    /**
     * 
     * @param aList 需要运算的字符串 比如"10+2*3+(5*4+4)/4";
     * @return
     */
    public Stack<String> experToRevExpersion(ArrayList<String> aList) {
        // 用于接收数字
        Stack<String> nStack = new Stack<>();
        // 用于接收运算符
        Stack<String> oStack = new Stack<>();
        String regex = "\\d+";
        for (String item : aList) {
            // 判断是否是数字
            if (item.matches(regex)) {
                nStack.push(item);
            // 如果遇到左括号，直接入运算符栈
            } else if (item.equals("(")) {
                oStack.push(item);
            // 如果遇到右括号，需要将运算符栈中的数据依次pop出，直到遇到左括号
            } else if (item.equals(")")) {
                while (true) {
                    if (oStack.peek().equals("(")) {
                        // 当遇到左括号时，先将其pop出，然后再break
                        // 这样左右括号都被舍弃掉
                        oStack.pop();
                        break;
                    }
                    // 将pop出的运算符依次放入数字栈
                    nStack.push(oStack.pop());
                }
            } else {
                if (oStack.empty()) {
                    oStack.push(item);
                // 判断当前的运算符和运算符栈顶的先后顺序
                }else if (ReverseCal.priority(item) > ReverseCal.priority(oStack.peek())) {
                    // 当前的运算符优先级大那么就将其放入运算符栈顶
                    oStack.push(item);
                } else {
                    // 当前运算符优先级小，先将符号栈顶的数据放入数字栈顶，然后将当前运算符加入运算符栈
                    nStack.push(oStack.pop());
                    oStack.push(item);
                }
            }
        }
        while (true) {
            // 顺序取出运算符栈的所有运算符，并且加入到数字栈
            if (oStack.size() == 0) {
                break;
            }
            nStack.push(oStack.pop());
        }
        return nStack;
    }
    /**
     * 用于计算逆波兰表达式
     * @param stack 后缀计算表达式
     * @return
     */
    public int getResult(Stack<String> stack) {
        Stack<String> temp = new Stack<>();
        // 先反转需要运算的表达式
        while (true) {
            if (stack.size() == 0) {
                break;
            }
            temp.push(stack.pop());
        }
        Stack<Integer> numStack = new Stack<>();
        String regex = "\\d+";
        while (true) {
            if (temp.size() == 0) {
                break;
            }
            if (temp.peek().matches(regex)) {
                numStack.push(Integer.parseInt(temp.pop()));
            } else {
                // 当遇到运算符，就从数栈中pop两个数字和当前的运算符进行计算
                int n1 = numStack.pop();
                int n2 = numStack.pop();
                String oper = temp.pop();
                numStack.push(ReverseCal.cal(n2, n1, oper));
            }
        }
        // 最后数栈会存在一个数字，就是计算结果
        return numStack.pop();
    }

    public static int cal(int num1, int num2, String operator) {
        int result = 0;
        switch (operator) {
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            default:
                break;
        }
        return result;
    }
}
