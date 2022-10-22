package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * 找出一个字符串当中，最长的一个回文串
 * 回文串指的是，正反读都一样。eg: abba, cbc等等
 * acba 这个就不是
 * 解析：如果一个字符串它的首尾l和r不相等，那么它一定不是回文串 
 * 而如果一个字符串的首尾相等，那么才有必要比较它的其它元素 l+1 r-1;
 */

public class LongestPalindrome {
    public static void main(String[] args) {
        String s_t = "abaweeew";
        System.out.println(longestPalindrome(s_t));
    }

    /*
     * 动态规划解法
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int strLen = s.length();
        int maxStart = 0; // 最长回文串的起点
        int maxEnd = 0; // 最长回文串的终点
        int maxLen = 1; // 最长回文串的长度

        // dp二维数组用于存储两个相比较字符的位置，并且记录他们是否相等
        boolean[][] dp = new boolean[strLen][strLen]; 
        // i 用于表示一直像字符串最右边移动的元素
        for (int i = 0; i < strLen; i++) {
            // j 用于表示来跟i对比是否相同的字符。当i移动一位，j会遍历一次字符串从下标为0的位置到i所对应的前一个位置。
            // 当j 的下标 和i 的下标相同的时候，肯定是回字串。所以不需要遍历到i的下标
            // 查找是否有相同的字符。如果i和j的字符相同，就需要分情况：
            // 1. 当i - j <= 2 表明他们中间最多有一个字符，那么此时他们就是回字串 eg： aba cc
            // 2. 当i - j > 2 表明他们中间至少有两个字符，那么就还要递归检查 i - 1 和 j + 1的字符是否相同。直到满足最后的i - j <= 2
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (i - j + 1 > maxLen) {
                        maxLen = i - j + 1;
                        maxStart = j;
                        maxEnd = i;
                    }
                }
            }
        }
        // 为什么要maxEnd + 1，是因为substring是左闭右开的结构。
        // s = "qweasd" s.substring(2, 4) => ea 下标为4的s不会被截取到
        // 所以需要maxEnd + 1
        return s.substring(maxStart, maxEnd + 1);
    }

    // 中心扩散法
}
