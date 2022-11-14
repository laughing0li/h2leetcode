package leetcode;

public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 3));
    }

    // 每一格里面存放的都是可以经过它的次数。
    // 第一行和第一列只会经过一次 所以先将他们置为1
    // 而后面的每一格它的次数等于它上面和左面一格的步数之和
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // 为什么要 减 1 是因为m 和 n 相当于length 所以需要减1
        return dp[m - 1][n - 1];
    }
    
}
