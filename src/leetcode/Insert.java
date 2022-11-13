package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] res = insert(intervals, newInterval);
        for (int[] i : res) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        int len = intervals.length;
        // 组装成一个新的数组，然后之前一样，先排序 再查找
        int[][] newIntervals = Arrays.copyOf(intervals, len + 1);
        newIntervals[len] = newInterval;
        List<int[]> result = new ArrayList<>();

        Arrays.sort(newIntervals, (v1, v2) -> v1[0] - v2[0]);

        result.add(newIntervals[0]);

        for (int i = 1; i < newIntervals.length; i++) {
            int[] curr = newIntervals[i];
            int[] peek = result.get(result.size() - 1);
            if (curr[0] > peek[1]) {
                result.add(curr);
            } else {
                peek[1] = Math.max(curr[1], peek[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
    
}
