package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {3, 10}, {15, 18}};
        int[][] res = merge(intervals);
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        // 后面是lambda方法
        // 这里的item 就是intervals 里面的一维数组，然后根据里面的一位数组的第一位数来排序
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
    
        List<int[]> res = new ArrayList<>();
        // 因为是要比较，先将第一个一维数组加入
        res.add(intervals[0]);
    
        // 从第二个一位数组开始比较
        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];
    
            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);

            // peek[1] 是 当前item的上一个item
            // eg：当前的item => {3, 10}, 那么peek[1] 就是 {2, 6}
            // 所以 是curInterval[0]一维数组里的第一个数字 和 那么result一维数组里的第二个数字进行比较。
            // 查看是否重叠
            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
