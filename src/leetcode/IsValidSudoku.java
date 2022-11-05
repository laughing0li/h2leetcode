package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class IsValidSudoku {
    
    public static void main(String[] args) {
    }

    // 将数独分为0-8九个box
    // i 为第几行 j为第几列。相当于 i 为纵坐标 j 为横坐标
    // 计算当前点位于第几个box的公式为 (i/3)*3 + j/3
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), box = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][i];
                // 因为hashmap接收的是Integer所以要将char转换成int
                if (c == '.') continue;
                int u = c - '0';
                // 确定是九个box中的第几个
                int numOfbox = i / 3 * 3 + j / 3;
                // 查询当前的 c 是否已经存在于row 或者 col 或者 box里面了。如果不存在 那就将其添加到hashmap里面
                if (row.get(i).contains(u) || col.get(i).contains(u) || box.get(i).contains(u)) {
                    row.get(i).add(u);
                    col.get(i).add(u);
                    box.get(numOfbox).add(u);
                }
            }
        }
        return true;
    }
    
}
