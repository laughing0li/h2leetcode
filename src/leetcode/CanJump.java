package leetcode;

public class CanJump {
    
    public static void main(String[] args) {
        // int[] nums = { 2,3,1,1,4 };
        int[] nums = { 3, 2, 1, 0, 5};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        // 声明一个k用于接收最大的步数
        int maxStep = 0;
        for (int i = 0; i < nums.length; i++) {
            // 运算一遍 就知道了 为什么当i 大于maxStep的时候就要跳出
            if (i > maxStep) return false;
            // nums[i] + i 表示第i个元素能够跳最远的距离
            maxStep = Math.max(maxStep, nums[i] + i);
        }
        return true;
    }

}
