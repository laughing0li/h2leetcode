package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 组合总和：给定的数组的元素没有重复的
 * 
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int targert) {
        // res 用来存放找到的合理的path
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, targert, res, path);
        return res;
    }

    /**
     * 
     * @param candidates
     * @param u 是数组中的下标
     * @param targert
     */
    public void dfs(int[] candidates, int u, int target, List<List<Integer>> res, List<Integer> path) {
        if (target < 0) return;
        if (target == 0) {
            // 当target等于零的时候，说明就找到了一个可行的
            // 如果不new一个新的，后续path发生变化，结果也会变化
            res.add(new ArrayList<>(path));
            return;
        }
        // u是给定数组的下标，这里设定 i = u是为了避免重复出现， 比如 [2 , 2, 3] [3, 2, 2]这种是重复
        // 如果i = 0 那么会将所有可能的排列组合找出来
        for (int i = u; i < candidates.length; i++) {
            // 当 candidates[i] 小于target的时候，说明它作为相加的元素
            if (candidates[i] <= target) {
                // 将candidates[i]加入到path，完整return的path就是一个解。 比如 2 + 2 + 3 = target 7
                // 2 2 3 就是path
                path.add(candidates[i]);
                // 递归查询 target - candidates[i] 很巧妙：因为如果第一个是2 那么target - 2 就剩下 5.剩下的只需要满足相加为5即可，以此类推
                dfs(candidates, i, target - candidates[i], res, path);
                // 这里就是回溯的关键 比如{ 1, 2, 3 }
                // 需要将 1 跟 2 3 分别进行计算。 当跟2 计算了之后 如果不将2 去掉那么就形成了123 计算了
                // 所以需要将 2 去掉 形成回溯
                path.remove(path.size() - 1);
            }
        }
    }
}