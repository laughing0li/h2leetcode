package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String to Interger (atoi)
 * 注意事项：
 * 1. 需要考虑极端情况，传入的字符串全部是空格组成
 * 2. int最大值为2147483647 最小值为-2147483648. 需要判断是否在此范围内
 * 3. 需要有一个变量来表示正或者负
 */
public class Atoi {
    public static void main(String[] args) {
        //-2147483648
        // 2147483647
        // double tmp = Math.pow(2, 31);
        String s = "   -2147483649";
        // String s = "   -21";
        System.out.println(atoi(s));
    }
    public static int atoi(String x) {
        int res = 0;
        // 字符串的下标
        int index = 0;
        // 用于表示正或者负。1为正 -1为负
        int sign = 1;
        char[] tmp = x.toCharArray();
        // 找到第一个不是空格的字符的位置
        while (index < tmp.length && tmp[index] == ' ') index++;
        // 说明该字符串全部是空格，这是极端情况需要考虑
        if (index == tmp.length) return 0;
        // 判断第一个非空格字符是否是符号位
        if (index < tmp.length && tmp[index] == '-' || tmp[index] == '+') {
            sign = tmp[index] == '-' ? -1 :1;
            index++;
        }
        while (index < tmp.length) {
            // 当前字符
            char curr = tmp[index];
            // 保证获取到的是0 - 9的数字
            if (curr > '9' || curr < '0') break;
            // 判断res是否已经大于了最大的int可接受的值，如果是 则直接返回int的最大值
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && Character.digit(curr, 10) > 7)) {
                return Integer.MAX_VALUE;
            }
            // 同理
            // 因为Character.digit(curr, 10)获取到的是正的数 所以它如果比8大 就证明该数比int可接受的最小值还小
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && Character.digit(curr, 10) > 8)) {
                return Integer.MIN_VALUE;
                
            }
            // 将获取到的字符跟res一起组成数字 例如字符串是“-2147483649”
            // 0 * 10 + 2 * sign => -2
            // -2 * 10 + 1 * sign => -21 以此类推
            res = res * 10 + Character.digit(curr, 10) * sign;
            index++;
        }
        return res;
    }
}
