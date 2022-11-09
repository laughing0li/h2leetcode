package leetcode;


public class Multiply {
    
    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        System.out.println(multiply(num1, num2));
    }


    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 结果的长度最多是m + n
        int[] position = new int[m + n];
        
        // 从后往前，因为最后面是各位。方便计算进位
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // num1 的 3 会跟 num2 的456 都相乘
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 两个数相乘最多是两位数，所以这是这个两位数在position里面的位置
                // i 和 j都是从 m - 1 和 n - 1开始的 所以当前num1[i] * num2[j] p1 是表示高位 p2 是表示低位的
                // 举例 p1 表示 十位 p2 表示 个位
                int p1 = i + j, p2 = i + j + 1;
                // p1 p2 的位置 是 0 1 | 1 2 | 2 3 | 3 4 所以能看到位置是有重复的
                // 为什么sum是这样的，因为当前的multiply还需要加上比他们更低位的数字
                int sum = multiply + position[p2];
                // 用于进位处理
                position[p1] += sum / 10;
                // position[p2] 用于存储当前sum里面的个位数字 也就是低位的数字
                position[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int p : position) {
            if (!(sb.length() == 0 && p == 0)) sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
}
