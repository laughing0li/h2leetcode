package sort;

/**
 * 从小到大的顺序
 * 数组的选择排序：先假设数组的第一个就是最小的，然后依次跟后面的进行比较。
 * 如果找到比最小的元素，就将这两个元素进行对调。然后再重复
 * 选择排序比冒泡排序速度更快
 */
public class SelectSort {

    public int[] selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 假设当前的第i个元素是最小的，然后将其和后面的元素依次比较
            int minIndex = i ;
            int min = nums[minIndex];
            // 因为当比较了一个之后，当前i这里肯定就是最小的数。
            // 所以j要从i开始比较，不然的话会出现重复的比较
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            // 将找到的最小值和当前的值对调，然后重复该方法
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
        return nums;
    }
    
    
}
