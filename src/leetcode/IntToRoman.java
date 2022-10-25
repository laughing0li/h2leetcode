package leetcode;

/**
 * 将数字转换成罗马数字
 * 
 * 使用贪心算法，从该数字的最大位开始
 */
public class IntToRoman {
    
    public static void main(String[] args) {
        System.out.println(intToRoman(3240));
    }

    public static String intToRoman(int num) {
        StringBuilder sBuilder = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        // 举例：num = 3240
        while (index < nums.length) {
            // 3240 大于1000 所以先给sBuilder里面加上一个千位的标识符M
            // 然后减去对应的1000. 继续比较直到个位数
            while (num > nums[index]) {
                sBuilder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return sBuilder.toString();
    }
}
