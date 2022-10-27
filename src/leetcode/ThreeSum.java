package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * 解题思路：
 * 首先将数组进行排序
 * 1. 初始i=0 表示数组第一个数、后期它会移动
 * 2. 初始j=1 表示i的下一个位置
 * 3. 初始k=数组长度减1. 表示最后一个位置
 * a 如果i + j + k < 0 就将 j向k的方向移动
 * b 如果i + j + k > 0 就将 k向j的方向移动
 * 如果i + j + k = 0 就将 i向k的方向移动1位，并且j = i + 1 继续ab步骤
 * 当i > 0 的时候就没必要进行下去了。因为三个数字都是大于零的
 */
public class ThreeSum {
    
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // 用于接收找到的三个数字组合
        List<List<Integer>> results = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len == 0) return results;
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            // 大于零说明，三个数相加一定大于零
            if (nums[i] > 0) break;
            // 只有当i大于零的时候，才需要比较当前的i和它前面的那个数是否相同
            // 如果相同，那么就不需要进行比较了，因为已经计算过了
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // 设定两个变量一个是i的前一个数，一个是数组的最后一个数
            int L = i + 1;
            int R = len - 1;
            // 当L 等于或者大于 R 说明已经比较到低了，需要将i重新+1 然后进行计算
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    results.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    // 也是去重，道理跟i那里是一样的。R 和 R-1 那么R - 1处就没必要进行计算了，直接指向它的下一位
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    // 为什么同时 L++ 和 R++ 是因为，此时i是不变的，所以如果L 和 R 不改变 
                    // 那么即使又找到了 sum等于0 也是重复的。所以需要同时移动
                    L++;
                    R--;
                }
                //  如果sum < 0 就将 L向 R的方向移动
                //  如果i + j + k > 0 就将 R向 J的方向移动
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return results;
    }
}
