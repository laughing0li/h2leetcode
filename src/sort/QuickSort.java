package sort;

import java.util.Arrays;

/*
 * 快速排序，是对冒泡排序的一种改进
 * 1. 先从数组当中选择一个元素当做基准值
 * 2. 以该基准值在数组中的实际位置，把数组分成两个子数组。一边是比它大的一边是比它小的
 * 3. 通过递归的方式对两个子数组进行快速排序，直到数组为空或者只有一个元素
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {4, 2, -1, 5, 2, 9};
        System.out.println(Arrays.toString(QuickSort.quickSort(nums, 0, 5)));
    }
    public static int[] quickSort(int[] nums, int left, int right) {
        int base, l, r, temp;
        
        if (left < right) {
            l = left; 
            r = right;
            // base作为基准参照数
            base = nums[l];    

            while (l < r) {
                // 这里的while 循环只要找到第一个符合条件的就会退出
                // 先从右边开始寻找，找到第一个小于base的数
                while(nums[r] >= base && l < r)
                    r--;
                // 然后从左边开始寻找，找到第一个大于于base的数
                while(nums[l] <= base && l < r) 
                    l++;
                // 找到这两个数字之后，需要将他们的位置进行调换
                temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            // 此时的nums[l]就是上面找到的第一个小于base的数，因为nums[l]和nums[r]
            // 调换了，没换之前nums[r]才是第一个小于base的数
            // 所以将left基准跟nums[l]对调，然后再使用递归。
            nums[left] = nums[l];
            nums[l] = base;
            // 
            quickSort(nums, left, l-1);
            quickSort(nums, l+1, right);
        }
        return nums;
    }
}
