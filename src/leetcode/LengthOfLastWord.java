package leetcode;

/**
 * 
 * 找出字符串从后往前，第一个非空 字符串
 * “ddd what ” 比如这里的what
 * 
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String ss = "a";
        System.out.println(lengthOfLastWord(ss));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length() - 1;
        // 首先从后往前找到第一个不为空的字符，并且记录下当前的index
        while (s.charAt(len) == ' ') len--;
        int end = len;
        // end 不能为0，否则会出错。去除了后面的空字符之后，就可以从后往前找，找到第一个为空的字符为止
        // 并且记录下此时的end。
        while (end >= 0 && s.charAt(end) != ' ') end--;
        return len - end;
    }
}
