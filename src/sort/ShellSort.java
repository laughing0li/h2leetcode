package sort;

import java.util.Arrays;

/**
 * 希尔排序法，也是选择排序的升级版
 * 它有两种实现方式：交换法和移动法
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        int temp = 0;
        // 以下三步的i的起始值都应该是从等于间隔开始。间隔分别是5，2，1
        // 第一步，将该数组分成5个小组，每组两个数字进行比较。
        // 两个数字不是相邻的，而是间隔了5的两个数字，比如nums[0] 和 nums[5]
        // i应该从step开始，所以这里是5
        // for (int i = 5; i < nums.length; i++) {
        //     // 当i等于5的时候，j就表示的是第0个元素。
        //     for (int j = i - 5; j >= 0; j -= 5) {
        //         if (nums[j] > nums[j + 5]) {
        //             temp = nums[j];
        //             nums[j] = nums[j + 5];
        //             nums[j + 5] = temp;
        //         }
        //     }    
        // }
        // for (int i = 2; i < nums.length; i++) {
        //     // j 为什么要自减。 举例：当i = 8的时候，j的起始值就为7
        //     // 如果不自减的话，那么我们比较的就只是 a[5] 和 a[7]
        //     // 前面的a[1] a[3]就没有比较。所以不会得到正确的答案
        //     for (int j = i - 2; j >= 0; j -= 2) {
        //         if (nums[j] > nums[j + 2]) {
        //             temp = nums[j];
        //             nums[j] = nums[j + 2];
        //             nums[j + 2] = temp;
        //         }
        //     }    
        // }
        // for (int i = 1; i < nums.length; i++) {
        //     for (int j = i - 1; j >= 0; j -= 1) {
        //         if (nums[j] > nums[j + 1]) {
        //             temp = nums[j];
        //             nums[j] = nums[j + 1];
        //             nums[j + 1] = temp;
        //         }
        //     }    
        // }
        System.out.println(Arrays.toString(ShellSort.moveSort(nums)));
    }

    // 交换法
    public static int[] changeSort(int[] nums) {
        int temp = 0;
        // 将上面的三步进行整合，发现 其中的 i 就是 gap 对2取余的结果
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (nums[j] > nums[j + 1]) {
                        temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
            }
        }
        return nums;
    }

    // 移动法

    public static int[] moveSort(int[] nums) {
        for (int gap = nums.length /2 ; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                // 这里使用插入排序法，先假设当前第i的位置为最小值
                int min = nums[i];
                int minIndex = i;
                if (nums[minIndex] < nums[minIndex - gap]) {
                    while (minIndex - gap >= 0 && min < nums[minIndex -gap]) {
                        nums[minIndex] = nums[minIndex-gap];
                        minIndex -= gap;
                    }
                    nums[minIndex] = min;
                }
            }
        }

        return nums;
    }
}
