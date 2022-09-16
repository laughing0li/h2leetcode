package recursion;

public class Maze {

    /**
     * 
     * @param x 纵坐标的纬度
     * @param y 横坐标的纬度
     * @return 返回二维数组模拟的迷宫地图
     */
    public static int[][] mazeMap(int x, int y) {
        int[][] map = new int[x][y];
            for (int n = 0; n < y; n++) {
                map[0][n] = 1;
                map[x-1][n] = 1;
            }
            for (int m = 0; m < x; m++) {
                map[m][0] = 1;
                map[m][y-1] = 1; 
            }
        // 为map设置障碍
        map[2][2] = 1;
        map[3][1] = 1;
        map[4][3] = 1;
        map[2][1] = 1;
        map[5][6] = 1;
        map[3][7] = 1;
        return map;
    }

    /**
     *  利用二维数组来模拟一个迷宫地图
     * 1. 假设从地图的 (1,1)开始出发走到(i-1, j-1)为终点，表明路线被找到
     * 2. 约定：当map[i][j] 为0表示该节点没被走过，为1表示墙 是不能通过
     *    为2表示通路可以走，为3表示该点已经走过但是走不通
     * 3. 在走迷宫的时候，需要定下一个如何行走的规则: 下->右->上->左
     *  表示开始往下走，如果下面不能走就走右边，右边不能走就走上面，以此类推
     * @param map 表示迷宫地图
     * @param x 表示开始的纵坐标
     * @param y 表示开始的横坐标
     * @return
     */
    public static boolean findWay(int[][] map, int x, int y) {
        int xlen = map.length;
        int ylen = map[0].length;
        // 该节点是终点位置，如果这里为2表示已经找到可以走通的路线了
        if (map[xlen-2][ylen-2] == 2) {
            return true;
        } else {
            if (map[x][y] == 0) { // 当当前节点还没被走过的时候
                map[x][y] = 2;
                // 分别尝试像下 右 上 左 走，如i果能够走通就返回true
                if (findWay(map, x+1, y)) {
                    return true;
                } else if (findWay(map, x, y+1)) {
                    return true;
                } else if (findWay(map, x-1, y)) {
                    return true;
                } else if (findWay(map, x, y-1)) {
                    return true;
                // 当上面所有的都走不通，表明该节点不通。就设置为3
                } else {
                    map[x][y] = 3;
                    return false;
                }
            } else { // map[x][y]不等于0 的情况
                return false;
            }
        }
    }
}
