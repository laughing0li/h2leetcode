package leetcode;

/**
 * 
 * 计算某数的n次方
 * 采用分治算法：分治算法，递归的去找寻当前是否有解
 * 
 * 此处以 x = 2.0, n = 10 作为例子
 * 递归1：2的10次方 解决不了，向下分解为 n = 10/2 = 5
 * 递归2：2的5次方 解决不了，向下分解为 n = 5/2 = 2
 * 递归3：2的2次方 解决不了，向下分解为 n = 2/2 = 1
 * 递归4：2的1次方 有解，向上回溯结果 2
 * 递归3：向上回溯结果 2 * 2 = 4
 * 递归2：向上回溯结果 4 * 4 * 2 = 32
 * 递归1：向上回溯结果 32 * 32 = 1024
 * 返回结果 1024 即可
 * 
 * 综上所述，整个分解的过程为 n^10 -> n^5 -> n^2 -> n^1
 */
public class MyPow {
    public static void main(String[] args) {
        MyPow p = new MyPow();
        System.out.println(p.myPow(2.1, -3));
    }

    public double myPow(double x, int n) {
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        // 需要对n是正数还是负数进行分开计算
        // 如果n小于0 就需要对 pow(x, n) 结果取倒数，就用 1 去除就可以了，为什么要用-n 因为-n等于 正的n这个时候
        return n > 0 ? pow(x, n) : 1 / pow(x, -n);
    }

    public double pow(double x, long n) {
        // why？
        if (Math.abs(n) == 1) return x;
        double y = pow(x, n / 2);
        // 需要区分 n 是单数还偶数
        return n % 2 == 0 ? y * y : y * y * x;
    }
}