package leetcode;

/**
 * 
 * 从给定的数字数组中查找一个数字
 * 二分法查找
 * 
 */
public class Search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }


    public static int search (int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            // 因为每次缩小范围mid都会不同，所以需要重新计算mid
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            if (nums[start] <= nums[mid]) {
                // 在mid 的左边查询
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                } 
                // 在mid 的右边查询
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
