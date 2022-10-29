package leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums, -2));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        if (nums == null || len == 0) return result;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
                if (sum > target) {
                    R--;
                } else if (sum < target) {
                    L++;
                } else {
                    return result;
                }  
            }
            
        }
        return result;
    }
}
