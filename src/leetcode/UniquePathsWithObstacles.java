package leetcode;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        int results = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(results);
    }
    // 二维数组里面的 0 表示可以通过， 1 表示障碍
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        // 第一个位置也需要判断是否能够走通，不能就置为0
        dp[0][0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        // 为什么要从 1 开始，因为需要判断 i - 1如果是 从0 开始那么就会报错 index out of range
        // 先处理第一行和第一列，如果有障碍就将其置为
        for (int i = 1; i < n; ++i) {
            // dp[i - 1][0] 为 0 说明当前这格的前一格是不能通过的，所以这一格也是不能通过的
            // obstacleGrid[i][0] == 1 说明 这一格是走不通的
            if (obstacleGrid[i][0] == 1 || dp[i - 1][0] == 0) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = 1;
            }
        }
        // 处理第一列的情况
        for (int i = 1; i < m; ++i) {
            if (obstacleGrid[0][i] == 1 || dp[0][i - 1] == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = 1;
            }
        }

        for (int i = 1; i < n; ++i) {
            for (int j = 1; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
    
}
