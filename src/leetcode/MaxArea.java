package leetcode;

/**
 * 
 * 找出最大容水量
 * 解题思路：这里的最大容积 暂时用 长*高 表示 => Len * height
 * 由此可以看出，最大容积跟长度和高度有关。所以我们先设想从最长的长度开始。
 * 
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxarea(height));
    }

    public static int maxarea(int[] height) {
        int maxarea = 0;
        int front = 0;
        int end = height.length - 1;
        // 当front 大于或者等于end break
        while (front < end) {
            // height[end] 和 height[frong] 谁小，谁就是高度
            if (height[front] > height[end]) {
                maxarea = Math.max(maxarea, (end - front) * height[end]);
                end--;                                                                                                                                                                                                                                                                                                           
            } else {
                maxarea = Math.max(maxarea, (end - front) * height[front]);
                front++;
            }
        }
        return maxarea;
    }
    
}