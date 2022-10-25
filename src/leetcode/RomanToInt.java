package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转int
 * 当小的值在大的值的左边：IV => 5-1=4
 * 当小的值在大的值的右边：VI => 5+1=6
 * 所以，我们先获取到字符串中第一个字符所对应的数字，然后将其与后一个进行比较大小。
 * 然后按照上面的规则进行运算。
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "CMXCIV";
        int result = romanToInt(s);

        System.out.println(result);
    }
    
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        // 获取到第一个字符所对应的数。
        int preNum = map.get(s.charAt(0));
        // 后续的每一个字符所对应的数都需要与其前一个字符对应的数进行比较大小。
        for (int i = 1; i < s.length(); i++) {
            int num = map.get(s.charAt(i));
            // 前一个数小于当前数就用result 就 减
            // eg CM => C 对应 100 M对应1000. 先遇到C小于M所以先减去C 再加上M 900也就是CM
            // 如果preNum大于num那么就直接加上preNum即可
            if (preNum < num) {
                result -= preNum;
            } else {
                result += preNum;
            }
            // 将preNum向后移动一位。
            preNum = num;
        }
        result += preNum;
        return result;
    }
}
