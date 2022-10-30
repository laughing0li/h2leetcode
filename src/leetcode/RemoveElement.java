package leetcode;

import java.util.Arrays;

/**
 * 
 * 给定一个数字，如果数组中含有该数字，那么全部移除，并且将它在数组中占有的位置填上已有的数字
 * 
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3 };
        System.out.println(Arrays.toString(removeElement(nums, 3)));
    }
    // 一个指针指向最后一个元素，当第i个元素就是要删除的
    // 那么就让第i个元素等于最后一个元素，并且将指针往前走一位。以此类推找到所有的
    public static int[] removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0)
            return nums;
        int end = nums.length;
        for (int i = 0; i < end;) {
            if (nums[i] == val) {
                nums[i] = nums[end - 1];
                end--;
            } else {
                // 当 num[i] 不等于 val的时候 i 才进行自加。
                i++;
            }
        }
        return nums;
    }

}
