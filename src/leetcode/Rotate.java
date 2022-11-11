package leetcode;

import java.util.Arrays;

public class Rotate {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3}, {4,5,6},{7,8,9}};
        rotate(matrix);
        for (int[] item : matrix) {
            System.out.println(Arrays.toString(item));
        }
        // System.out.println(matrix[0][0]);
        // System.out.println(matrix[0][1]);
        // System.out.println(matrix[0][2]);
    }
    // 二维数组来表示数字矩阵图
    // 解题思路：先以 左上-右下 为对角线做反转， 然后再以中心的竖线做反转即可

    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            // 画图就可以理解，以中轴线来左右反转，只需要计算len / 2就好了 不然会重复。
            // 画图理解
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}
