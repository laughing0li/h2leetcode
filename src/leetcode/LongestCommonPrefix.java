package leetcode;

/**
 * 寻找最长的公共前缀
 * 解题思路：使用第一个数组元素作为参照组。然后对每一个字符进行比较。只要找到不相等字符就 返回
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
    }

    public static String longestCommonPrefix(String[] s) {
        if (s.length == 0 || s == null) {
            return "";
        }
        for (int i = 0; i < s[0].length(); i++) {
            // 将字符串数组的第一个字符串用作对照
            char compare = s[0].charAt(i);
            // 因为已经将第一个数组元素拿出来作为对照了，所以j从1开始遍历
            for (int j = 1; j < s.length; j++) {
                // i == s[j].length() 表明至少有一个字符串的所有字符都被比较过了。所有就没必要继续比较下去
                // 只要当前字符和作为对照的字符不同，就结束
                // 注意：这里的顺序，要先比较是否到达了某个字符串的最后，然后再去比较字符是否相同，否则有可能出现 String index out of range error
                if (i == s[j].length() || compare != s[j].charAt(i)) {
                    return s[0].substring(0, i);
                }
            }
        }
        return s[0];
    }
}
