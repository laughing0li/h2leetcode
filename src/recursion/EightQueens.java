package recursion;

public class EightQueens {
    // 表示多少个皇后，也代表着该棋盘有多少行，每一行有且只有一个皇后
    public int max;
    // 用于存放每一个皇后在棋盘中对应的位置，该位置就是皇后在某一行的某一列
    // 数组的下标就可以用来表示对应的第几行皇后
    public int[] queens = new int[max];
    public static int count = 0;
    public EightQueens(int maxSize) {
        max = maxSize;
        queens = new int[maxSize];
    }
    
    // n是从0开始的，也就是从第一个皇后开始往里面放
    public void check(int n) {
        // 当n等于8的时候，是表明的第九个皇后。所以在第九个的时候直接就return。
        // 前8个皇后就都被放置于棋盘了
        if (n == max) {
            display();
            return;
        }
        for (int i = 0; i < max; i++) {
            // 先将当前的皇后n放入到
            queens[n] = i;
            // 当judge为true的时候，表明当前n皇后的位置是正确的
            // 所以就可以继续操作n+1的皇后
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    /**
     * 查看第n个皇后和前面放置的皇后是否冲突
     * @param n 表示第几个皇后
     * @return
     */
    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 如果queens[i] == queens[n]表明第i个皇后是跟第n个皇后在同一列。不行
            // Math.abs(n - i) == Math.abs(queens[n] - queens[i])) 能够判断出第n个皇后和第i个皇后是否在一条斜线上
            // 这个不是很好理解，可以画图来理解一下
            if (queens[i] == queens[n] || Math.abs(n - i) == Math.abs(queens[n] - queens[i])) {
                return false;
            }
        }
        return true;
    }

    public void display() {
        count++;
        for (int i = 0; i < queens.length; i++) {
            System.out.print(queens[i]);
        }
        System.out.println();
    }
}
