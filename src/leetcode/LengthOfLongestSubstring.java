package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abba";
        System.out.println(solution(s));
    }
    /**
     * 
     * @param s
     * @return
     */
    public static int solution(String s) {
        // result 用于接收最长的长度
        int n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        // end 和 start 用于表示它们对应的字符串的下标
        // 每次循环将end向后移动一位
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            // 检查当前的元素是否存在于map当中。
            if (map.containsKey(alpha)) {

            //  为什么要start = Math.max(map.get(alpha) + 1, start) 
            //  而不是直接 start = map.get(alpha) + 1
            // 以”deedf”为例，在经过第一轮判断e重复之后，start和end同时指向第二个e，end继续向后移，
            // 此时遇到了重复的d字符，但此时map中所包含的d的kv值仍是第一个d的。
            // 此时为了避免start指针回到了第一个位置，所以需要判断最大值使得指针不会回到最开始的d的位置。
                start = Math.max(map.get(alpha) + 1, start);
            }
            // 每次循环都需要算出当前不重复的长度end - start + 1。
            // 并且跟已有的result进行比较，大于result就将其替换掉。
            result = Math.max(result, end - start + 1);
            // 如果没有找到重复的，那么就将end对应下标的字符加入到map中
            map.put(s.charAt(end), end);
        }
        return result;
    } 
}
