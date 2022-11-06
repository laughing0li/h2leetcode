package leetcode;

/**
 * 
 * count and say 外观数组。
 * 给定一个数字，这个数字是一个count
 * 然后从 1 开始表示这个外观数组。需要往后数count下
 * 后面一个元素是对前一个元素的个数描述
 * 比如count等于4 那就是需要从1开始走往后走四次
 * 1 11 21 1211 1 一个1 两个1 1个2 1个1
 * 解题思路：两个指针
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    public static String countAndSay(int n) {
        // 初始化一个pre和cur
        StringBuilder pre = new StringBuilder("1"), cur = new StringBuilder("1");

        for (int i = 1; i < n; i++) {
            pre = cur;
            // 每次循环都要重新初始化cur，不能让之前的字符串加入
            cur = new StringBuilder();
            // 双指针
            int start = 0, end = 0;
            while (end < pre.length()) {
                while (end < pre.length() && pre.charAt(start) == pre.charAt(end)) {
                    end++;
                }
                // 当 start 和 end指向的字符不同的时候，意味着找寻结束。
                // end - start 是指当前字符的个数
                cur.append(end - start);
                cur.append(pre.charAt(start));
                // 将start指向 end 继续寻找下一个相同的数字
                start = end;
            }
        }
        return cur.toString();
    }
}
