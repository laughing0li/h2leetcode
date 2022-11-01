package leetcode;

/**
 * 
 * 给定两个数，不使用除法 乘法 和 模运算 求出来两个数的商
 * 
 */
public class Divide {
    public static void main(String[] args) {
        Divide d = new Divide();
        System.out.println(d.divide(-4, 3));
    }

    public int divide(int dividend, int divisor) {
        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;
        // 当除数是最小的整数 并且 被除数为 -1 的时候，值会刚好比最大的整数大1.会溢出
        // 所以直接返回最大的整数
        if (dividend == min && divisor == -1)
            return max;
        // sign 用于表示符号 1 为正 -1 为负
        int sign = 1;
        // 当满足下面的条件，sign 就为负
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        // 全部转为负数，防止溢出。
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        // 用于接收结果
        int result = 0;

        // 当负的除数 小于 被除数的时候，也就是相当于 除数大于 被除数的时候，就需要一直循环下去。
        // 都是负数的时候 比较正好相反
        // 因为dividend 需要 和 divisor 比较，所以divisor 不能动
        while (dividend <= divisor) {
            // tmp 表示每次计算时的被除数。从等于divisor。每次增加一倍
            int tmp = divisor, count = 1;
            while (tmp >= dividend - tmp) {
                // 将count 和 tmp 倍增，<<= 相当于乘以2然后再赋值给tmp 和 count
                tmp <<= 1;
                count <<= 1;
            }
            // 每次dividend需要减去当前的被除数
            dividend -= tmp;
            result += count;
        }
        // 根据sign来返回值是 正的还是负的
        return sign < 0 ? -result : result;
    }

}
