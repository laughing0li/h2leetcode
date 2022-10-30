package leetcode;

import java.util.Arrays;

/**
 * 
 * 给定一个顺序数字数组，删除重复数字
 * 然后计算出 不重复的数字的长度 K
 * 
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        System.out.println(Arrays.toString(removeDuplicates(nums)));
    }

    public static int[] removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        // start 为 下标值，start + 1 才是需要找的那个 K 值
        // 并且当所有的不重复数字找到过户，start对应的那个数就是最后一个不重复的数字。
        // 所以不重复的数字长度 为 start + 1
        int start = 0;
        int end = 1;
        while (end < nums.length) {
            if (nums[start] == nums[end]) {
                nums[end] = 0;
                end++;
            } else {
                start++;
                nums[start] = nums[end];
                // 需要将end 指向下一个。
                end++;
            }
        }
        return nums;
    }

}
