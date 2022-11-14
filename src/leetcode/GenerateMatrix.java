package leetcode;

import java.util.Arrays;

public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }

    // 这个题的核心是，从左至右，从上到下，从右到左，从下到上这个顺序 来放入 i++
    public static int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] result = new int[n][n];
        int num = 1, target = n * n;
        while (num <= target) {
            for (int i = left; i <= right; i++) result[top][i] = num++;
            top++;
            for (int i = top; i <= bottom; i++) result[i][right] = num++;
            right--;
            for (int i = right; i >= left; i--) result[bottom][i] = num++;
            bottom--;
            for (int i = bottom; i >= top; i--) result[i][left] = num++;
            left++;
        }
        return result;
    }
    
}
