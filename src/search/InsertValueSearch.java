package search;

/**
 * 插值查找算法：与二分查找类似。不同的是它的mid是经过一个公式算出来的
 * 这个公式跟需要查找的元素有关。并且插值查找优点是在查找连续的元素的头或者尾的时候需要运算递归的次数较少
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        int index = InsertValueSearch.insertValueSearch(nums, 0, nums.length - 1, 100);
        System.out.println(index);
    }
    /**
     * 
     * @param nums
     * @param L
     * @param R
     * @param num
     * @return
     */
    public static int insertValueSearch(int[] nums, int L, int R, int num) {
        // 因为是连续的序列，所以查找的元素不能小于第一个或者大于最后一个
        if (L > R || num < nums[0] || num > nums[R]) {
            return -1;
        }
        System.out.println("====");
        int mid = L + (R - L) * (num - nums[L]) / (nums[R] - nums[L]);
        if (nums[mid] > num) {
            return insertValueSearch(nums, L, mid - 1, num);
        } else if (nums[mid] < num) {
            return insertValueSearch(nums, mid + 1, R, num);
        } else {
            return mid;
        }
    }
}
