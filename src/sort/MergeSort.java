package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {8, 4, 5, 7, 1, 3, 6, 2};
        MergeSort.sort(nums, 0, 7);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 
     * @param nums
     * @param L
     * @param R
     * @return
     */
    public static void sort(int[] nums, int L, int R) {
        if (L >= R) {
            return ;
        }
        int mid = (L + R) / 2;
        sort(nums, L, mid);
        sort(nums, mid+1, R);
        merge(nums, L, mid, R);
    }
    /**
     * 
     * @param nums 需要排序的数组
     * @param L 左边序列的初始索引
     * @param M 指向数组分隔的元素，中间索引
     * @param R 右边序列的初始索引
     * 都是指的下标
     * @return
     */
    public static void merge(int[] nums, int L, int M, int R) {
        int i = L; // 表示左边数组的第一个位置
        int j = M + 1; // 表示右边数组的第一个位置， 因为规定M值属于左边数组
        int t = 0; // 表示temp数组的index
        int[] temp = new int[nums.length];
        // i++ 和 ++i的区别：前者是先赋值后自加，后者是先自加再赋值
        while (i <= M && j <= R) {
            if (nums[i] > nums[j])
                temp[t++] = nums[j++];
            else
                temp[t++] = nums[i++];
        }
        while (i <= M )
            temp[t++] = nums[i++];
        while (j <= R) 
            temp[t++] = nums[j++];

        // 需要将temp里的数据copy到nums数组中
        for (int m = 0; m < t; m++) {
            nums[m + L] = temp[m];
        }
        temp = null;
    }
    
}
