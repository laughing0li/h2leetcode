package leetcode;

import java.util.Arrays;

public class PlusOne {
    
    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    // 
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        // 从最后开始往前循环
        for (int i = len - 1; i >= 0; i--) {
            // 如果当前为9 那么就直接置为0
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // 如果当前位置不为 9 那么就直接加 1 然后 return 就好
                // eg {1 , 2, 3} 3 不为9 那么直接返回 3+1 之后的数组 124 即可
                digits[i] += 1;
                return digits;
            }
        }
        // 特殊情况，如果数组全是9，{9, 9, 9, 9}
        // 先创建一个len + 1的数组，然后置为{1 0 0 0 0} 即可
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
