package leetcode;

import java.util.LinkedList;

/**
 * 利用栈来进行辨别
 */
public class IsValid {

    public static void main(String[] args) {
        String s = "([]{})";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        // 无论是哪种括号，只要遇到左半边括号，就将它推入到栈中
        for (char c : chars) {
            if (c == '(')
                stack.add(')');
            else if (c == '{')
                stack.add('}');
            else if (c == '[')
                stack.add(']');
            // || 只要有一个条件满足就返回true。
            // 当第一个条件为false 还会去判断第二个条件，
            // 当第一个条件为true，直接返回true。不会计算第二个条件

            // 每次检查都有两种情况，当栈为空的时候直接返回false
            // 当栈不为空的时候，就需要将当前的c和栈中最后一个进行比较是否相同
            else if (stack.isEmpty() || c != stack.removeLast())
                return false;
        }
        return stack.isEmpty();
    }
}
