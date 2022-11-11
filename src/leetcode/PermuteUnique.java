package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {

    public static void main(String[] args) {
        int[] nums = {1, 1, 3};
        PermuteUnique p = new PermuteUnique();
        System.out.println(p.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, path, nums, new boolean[nums.length]);
        return res;
        
    }

    public void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) continue;
            if (used[i] == false) {
                used[i] = true;
                path.add(nums[i]);
                backtracking(res, path, nums, used);
                path.remove(path.size() - 1);
                // 回溯，这里就是为什么nums[i] == nums[i - 1] && used[i - 1] == false 就表明同层重复了
                // 因为used[i - 1] 在下一次循环的时候会回溯成false
                used[i] = false;
            }
        }
    }

}