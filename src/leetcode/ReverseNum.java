package leetcode;

/**
 * 
 * 注意事项：Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 * 表明只能用int去接收，也就是最大是32位的。不能用long。
 * int的范围是 -2147483648 <= x <= 2147483647
 * 
 */
public class ReverseNum {
    public static void main(String[] args) {
    }    

    public static int reverse(int x) {
        // 用于接收反转后的数字
        int res = 0;
        while (x != 0) {
            // 每次循环都获取到x的末尾数字
            int temp = x % 10;
            // 当满足下面的条件的时候，说明res会比 int能接受的最大数字还要大，所以会溢出
            if (res > 214748364 || (res == 214748364 && temp > 7)) {
                return 0;
            }
            // 当满足下面的条件的时候，说明res会比 int能接受的最小数字还要小，所以会溢出
            if (res < -214748364 || (res == -214748364 && temp < -8)) {
                return 0;
            }
            // 每次循环，如果满足条件 就将temp加入到res的各位
            // eg: res = 0 temp = 5 => res = 0 * 10 + 5 = 5
            //     res = 5 temp = 4 => res = 5 * 10 + 4 = 54
            // 以此类推
            res = res * 10 + temp;
            // 对x就要做相反的操作，需要将它的个位数清除掉
            x /= 10;
        }

        return res;
    }

}
