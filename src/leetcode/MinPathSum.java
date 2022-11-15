package leetcode;

public class MinPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4, 2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            } 
        }
        return grid[n - 1][m - 1];
    }
    
}
