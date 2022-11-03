package leetcode;

import java.util.Arrays;

/*
 * 
 * 找出当前数组排列的下一个数组排列，也就是比当前数组排列组合的最小大于的数组排列
 * eg: 数组 nums 和 i,j 两个指针 分别对应倒数第一个和倒数第二个元素
 * 当 nums[i] 小于 nums[j]的时候 我们就找到了最小最大数
 * 然后 在下标 j 到 end 里面从后往前找到第一个比nums[i]大的数 end表示最后一个下标
 * 然后将nums[i] 和 那个数进行交互，然后再将 从i + 1 到 end的元素按照升序排列即可
 * 
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 8, 9, 2};
        // int[] nums = { 1, 3, 2 };
        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
        // n.reverse(nums, 0);
        System.out.println(Arrays.toString(nums));
    }
    // 从后面往前找，只要后面的比前面的大，那么就找到了最小的最大数
    public void nextPermutation(int[] nums) {
        int tmp = 0;
        boolean flag = true;
        // 找到第一次出现 第 i - 1 个元素 小于第 i 个元素 然后break
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                tmp = i - 1;
                flag = false;
                break;
            }
        }
        // 找出从第i - 1 个元素之后 从 数组的尾部往前 找到第一个大于i-1的元素。进行交换，最后再升序排列
        for (int i = nums.length - 1; i > tmp; i--) {
            if (nums[i] > nums[tmp]) {
                swap(nums, i, tmp);
                // 从tmp的下一个开始进行升序排列
                reverse(nums, tmp + 1);
                break;
            }
        }
        // 特殊条件，如果数组本来是按照降序排列的，那么直接升序排列即可
        if (flag) reverse(nums, 0);
    }

    public void swap(int[] nums, int n, int m){
        int tmp = 0;
        tmp = nums[n];
        nums[n] = nums[m];
        nums[m] = tmp;
    }

    /**
     * 将i到end的元素进行升序排序
     * @param nums
     * @param i nums数组下标i
     */
    public void reverse(int[] nums, int i) {
        int len = nums.length - 1;
        while (i < len) {
            swap(nums, i, len);
            i++; len--;
        }
    }
    
}
