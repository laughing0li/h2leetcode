package leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        String ss = "a";
        System.out.println(lengthOfLastWord(ss));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length() - 1;
        while (s.charAt(len) == ' ') len--;
        int end = len;
        while (end >= 0 && s.charAt(end) != ' ') end--;
        return len - end;
    }
}
