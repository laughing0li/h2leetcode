package leetcode;

public class SearchInsert{
    public static void main(String[] args) {
        int[] nums = { 1,3,5,6 };
        System.out.println(searchInsert(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 为什么返回的是left，可自己画图试试
        return left;
    }

}