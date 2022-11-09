package leetcode;

/**
 * 
 * 跳跃游戏：使用贪心算法
 * 解题思路 当第一次找maxPosition，肯定是2 所以可以向后跨2步最多。然后比较后面两步的数哪一个大
 * 很明显3 大于 1 那么我们就跨到3. 然后3 后面可以最多走三步。就可以直接到底了 走了两次
 */
public class Jump {
    public static void main(String[] args) {
        int[] nums = { 2,3,1,1,4 };
        int steps = jump(nums);
        System.out.println(steps);
    }
    public static int jump(int[] nums) {
        int step = 0, end = 0, maxPosition = 0;
        // 为什么是nums.length - 1是因为最后一个元素不能作为起跳点
        for (int i = 0; i < nums.length - 1; i++) {
            // nums[i] + i 表示的是在该位置可以跳跃的最大数
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                step++;
            }
        }
        return step;

    }

}
