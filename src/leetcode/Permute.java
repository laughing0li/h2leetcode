package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permute {

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = { 1, 2, 3 };
        System.out.println(p.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        backtracking(nums, len, 0, new ArrayDeque<>(), used, res);
        return res;
    }
    // Deque 是双端队列，元素可以添加到头部或者尾部，取元素也是一样
    public void backtracking(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // depth 等于len表示
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 表示i这个index的元素还没被使用
            if (used[i] == false) {
                path.addLast(nums[i]);
                used[i] = true;
                backtracking(nums, len, depth + 1, path, used, res);
                used[i] = false;
                path.removeLast();
            }
        }
    }
    

}
