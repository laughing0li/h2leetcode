package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] nums = {{1,2,3}, {4,5,6}, {7,8,9} };
        List<Integer> res =  spiralMatrix(nums);
        System.out.println(nums[0][2]);
        System.out.println(nums[1][2]);
        System.out.println(nums[2][2]);
    }

    public static List<Integer> spiralMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // 定义上下左右的边界
        // 当上边界大于等于下边界的时候，说明该跳出。就返回答案
        int up = 0, down = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (true) {
            // 横向打印，所以up是在同一行
            for (int i = left; i <= right; i++) result.add(matrix[up][i]);
            // ++i 先自加再比较。当横移结束了之后 需要把up向down移动一位。然后进行比较
            if (++up > down) break;
            //  为什么要先自加或者自减，为了避免拐角的元素重复被选。
            for (int i = up; i <= down; i++) result.add(matrix[i][right]);
            // 同理，从right 到left移动了之后，需要将right 向 left 移动一位。因为right在最右边，所以是自减
            if (--right < left) break;
            for (int i = right; i >= left; i--) result.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) result.add(matrix[i][left]);
            if (++left > right) break;

        }


        return result;
    }
    
}
