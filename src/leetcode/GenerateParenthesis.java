package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 括号是（）
 * 本题使用深度优先遍历进行解答
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * 因为是左括号先放，所以必须满足  left > right 
     * @param curStr 当前递归的结果
     * @param left 左括号的个数
     * @param right 有括号的个数 
     * @param n ()成对括号的个数
     * @param res 
     */
    public void dfs(String curStr, int left,  int right, int n, List<String> res) {
        // 当 左右括号数为n的时候，就表示结束。
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        // 左括号数不能小于有括号数，因为左括号是先放的
        if (left < right) return;

        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right > n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }
}
