package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 
 * 组合总和：给定的数组元素有重复的 
 * 
 */
public class CombiantionSum2 {
    
    public static void main(String[] args) {
        int[] nums = { 10,1,2,7,6,1,5 };
        CombiantionSum2 c = new CombiantionSum2();
        System.out.println(c.combinationSum2(nums, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;

        // 将重复的数字放到一起
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        backtracking(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * 
     * @param candidates 给定的数字数组
     * @param len       数组的长度
     * @param begin     从给定的数组的begin下标开始搜索，它是会改变的
     * @param target    表示剩余，这个值开始的时候等于 target， 但是中途会减去比target小的值，直到它小于或者等于0为止
     * @param path      从根节点到叶子节点的路径，当path满足各个节点相加等于target 就将path 加入到res。 然后再将path回溯
     * @param res
     */
    public void backtracking(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        // 当target 等于0 就表示找到了正确的顺序
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 如果当candidates[i] 大于 target 那么直接就break。减去它都大于零了 就没必要往下走了
            if (target - candidates[i] < 0) break;
            /**
             * 
                这个方法最重要的作用是，可以让同一层级，不出现相同的元素。即
                                 1
                                / \
                               2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
                              /     \
                             5       5
                                例2
                                 1
                                /
                              2      这种情况确是允许的
                             /
                            2  
                                
                为何会有这种神奇的效果呢？
                首先 i == i - 1 是用于判定当前元素是否和之前元素相同的语句。这个语句就能砍掉例1。
                可是问题来了，如果把所有当前与之前一个元素相同的都砍掉，那么例二的情况也会消失。 
                因为当第二个2出现的时候，他就和前一个2相同了。
                                
                那么如何保留例2呢？
                那么就用 i > begin 来避免这种情况，你发现例1中的两个2是处在同一个层级上的，
                例2的两个2是处在不同层级上的。
                在一个for循环中，所有被遍历到的数都是属于一个层级的。我们要让一个层级中，
                必须出现且只出现一个2，那么就放过第一个出现重复的2，但不放过后面出现的2。
                第一个出现的2的特点就是 i == begin. 第二个出现的2 特点是 i > begin.
             * 
             */
            // 当 i 大于 begin 表示已经进入到了至少调用了下一次的backtracking了 所以是不同层级的了。
            // continue 表示跳过后面的语句 进行下一个循环。会将第一个出现的2 加入到path
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            path.addLast(candidates[i]);
            // 因为元素是不能重复的 所以这里应该传递i + 1
            backtracking(candidates, len, i + 1, target - candidates[i], path, res);
            // 形成回溯
            path.removeLast();
        }
    }

}
