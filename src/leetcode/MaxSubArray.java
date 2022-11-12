package leetcode;

import java.util.Arrays;

public class MaxSubArray {

    public static void main(String[] args) {
        // int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
        int[] nums = { -2, -1 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // 声明一个result用于接收。因为是要比较的，所以让它从等于nums[0] 开始
        int result = nums[0];
        int sum = 0;
        for (int num : nums) {
            // 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
            // 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
            // 每次比较 sum 和 result的大小，将最大值置为result，遍历结束返回结果
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

}
