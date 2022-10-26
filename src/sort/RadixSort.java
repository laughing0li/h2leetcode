package sort;


/**
 * 基数排序：
 * 1. 先比较个位数，无论这个数有多大，我们都先只比较个位数的大小。
 * 2. 然后比较十位数，如果没有十位数，那么就在该数前面添加一个0.它会在最小的位置
 * 3. 比较百位数 等
 * 4. 每一次排序，桶就表示那一位数的从小到到或者从大到小：比如十位数的 1， 2，3 比较的是每个数的十位的大小
 * eg: 432 和 23 这个时候就是比较的第一个数的3 和第二个数的2的大小。以此类推
 * 5. 这种方法需要先找到序列中最大的一位数，然后根据它来确定最后比较的是十位还是百位或者千位
 */
public class RadixSort {
    // main方法里面是解析思路
    public static void main(String[] args) {
        int[] nums = { 53, 3, 542, 14, 215 };
        int max = nums[0];
        // 找到序列中最大的一位数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        // 算出最大的数一共有多少位
        // int maxLength = Integer.toString(max).length();

        // 长度为10的数组用于表示第几个桶
        // 长度为nums.length的数组用于表示一个桶。每个桶极端情况下存放nums.length个数据
        int[][] bucket = new int[10][nums.length];

        // 定义一个数组，他的每一个元素都是其对应的桶中的数据个数
        // eg: bucketElementCounts[2] 表示下标为2的桶中的数据个数。
        int[] bucketElementCounts = new int[10];
        // 先根据个位数的大小进行第一次排序
        for (int i = 0; i < nums.length; i++) {
            // digitOfElement 表示当前这个数应该去第几个桶
            int digitOfElement = nums[i] % 10;
            // 将该数加入到对应的桶中
            // [bucketElementCounts[digitOfElement]++为什么要这么做
            // 首先当没有加入数据的时候[bucketElementCounts[digitOfElement]等于0.自加过后等于1
            // 表示里面有一个数据，以此类推。如果等于2就表示有两个数据
            bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = nums[i];
        }
        // index 用于表示nums的索引
        int index = 0;
        // 遍历bucketElementCounts，获取到对应每一个桶中的数据个数
        for (int i = 0; i < bucketElementCounts.length; i++) {
            // 不等于0表示该桶有数据
            if (bucketElementCounts[i] != 0) {
                // bucket[i][j] 表示的是 第i个桶里面的第j个数据。
                for (int j = 0; j < bucketElementCounts[i]; j++) {
                    // 当在nums[index]放了数据，需要将index向后移动
                    nums[index++] = bucket[i][j];
                }
            }
            // bucketElementCounts[i]等于0，就等于下次放入数据还是从下标为0的位置开始存放
            bucketElementCounts[i] = 0;
        }
        // 对于十位和百位数的比较跟个位数的类似。注意点是需要将bucketElementCounts 置空。然后重新接收数据
        // 十位的比较 num / 10 % 10 百位数的 num / 100 % 10 以此类推

    }

    public static void bucketSort(int[] nums) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int maxLength = Integer.toString(max).length();

        int[][] bucket = new int[10][nums.length];

        int[] bucketElementCounts = new int[10];

        for (int j = 0; j < maxLength; j++) {
            for (int i = 0; i < nums.length; i++) {
                int digitOfElement = (int) (nums[i] / Math.pow(10, j) % 10);
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = nums[i];
            }
            int index = 0;
            // 从
            for (int i = 0; i < bucketElementCounts.length; i++) {
                if (bucketElementCounts[i] != 0) {
                    for (int k = 0; k < bucketElementCounts[i]; k++) {
                        nums[index++] = bucket[i][k];
                    }
                }
                bucketElementCounts[i] = 0;
            }
        }
    }

}
