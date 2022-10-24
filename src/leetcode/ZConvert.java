package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Z字形变换：将一个字符串按照指定的层数以z字形打印：
 * eg： abcdwerxzs 三层
 * a   w   z
 * b d e x s 
 * c   r
 */
public class ZConvert {
    public static void main(String[] args) {
        System.out.println(convert("ab", 1));
    }
    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;
        // 因为后面会对rows进行拼接，如果使用String性能很差，所以使用StringBuilder
        List<StringBuilder> rows = new ArrayList<>();
        // 初始化list，长度为numRows。下标 + 1就代表层数。第一层 第二层。。。
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        // 因为在第一运算的时候 flag = -flag, 而层数需要为正，所以flag = -1
        int i = 0, flag = -1;
        // 为每一行对应的rows添加字符
        for (char c : s.toCharArray()) {
            // 向该行追加元素
            rows.get(i).append(c);
            // 利用flag在 碰到第一行或者最后一行的时候进行反转
            if (i == 0 || i == numRows -1 ) flag = -flag;
            // eg: 当flag 为1， i = 0 ，1， 2. 反转的时候 flag = -1， i = 2, 1, 0
            // 所以 i += flag 非常的巧妙
            i += flag;
        } 
        // 同理，这里也需要拼接，使用StringBuilder性能更好
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
