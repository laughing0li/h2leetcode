package search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找的序列必须是有序的，这里举例的是从小到大的序列
 * 二分查找的实现: 
 * 1. 将需要查找的数与序列的中间元素对比。如果需要查找的数大于中间元素那么就向右边递归
 * 如果小于中间元素就往左边递归
 * 2. 需要约定，L > R 说明已经查询了整个序列。这就是该查找的退出条件
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 18, 91, 91, 91, 234, 1000};
        List<Integer> index = binarySearch(nums, 0, nums.length - 1 , 1000);
        System.out.println(index);
    }
    

    /**
     * 
     * @param nums 待查找的序列
     * @param L 左边索引
     * @param R 右边索引
     * @param num 需要查找的元素
     * @return
     */
    public static List<Integer> binarySearch(int[] nums, int L, int R, int num) {
        // 查询的退出条件
        if (L > R) {
            return new ArrayList<Integer>();
        }
        int mid = (L + R) / 2;
        if (num > nums[mid]) {
            return binarySearch(nums, mid + 1, R, num);
        } else if (num < nums[mid]) {
            return binarySearch(nums, L, mid - 1, num);
        } else {
            // 如果需要查找的num存在多个，那么就将其index放入ArrayList中
            List<Integer> reList = new ArrayList<Integer>();
            int lIndex = mid - 1;
            while (true) {
                if (lIndex < 0 || nums[lIndex] != num) {
                    break;
                }
                reList.add(lIndex--);
            }
            // 左边添加了过后再添加中间的，这样就是有序的
            reList.add(mid);
            int rIndex = mid + 1;
            while (true) {
                // 这里右边比较的时候，需要注意rIndex 需要先检验它是否大于nums.length -1 
                // 否则如果真的大于 那么nums[rIndex]会抛出 index out of bounds 错误
                if (rIndex > nums.length - 1 || nums[rIndex] != num) {
                    break;
                }
                reList.add(rIndex++);
            }
            return reList;
        }
    }
}
