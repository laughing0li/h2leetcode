package leetcode;


/**
 * 
 * 找出needle字符串是否存在于haystack字符串
 * 
 */
public class StrStr{
    public static void main(String[] args){
        String a = "sadbutsad";
        String b = "ad";
        System.out.println(StrStr.strStr(a, b));
    }

    // 思路是，把needle的字符分别与haystack里面的字符比较
    // 在循环的时候，只有当他们的字符是相等的 b和a指针才会向后移动
    // 所以在b 等于 needle的长度的时候，肯定就是找到了，然后返回此时的i即可
    public static int strStr(String haystack, String needle) {
        int h_len = haystack.length(), n_len = needle.length();
        char[] h = haystack.toCharArray(), n = needle.toCharArray();
        for (int i = 0; i <= h_len - n_len; i++) {
            // a 等于 i的原因：当上一个i不是需要的字符，a也需要跟i一样移动，而不是从h[0]开始
            int a = i, b = 0;
            while (b < n_len && h[a] == n[b]) {
            // 如果相等，那么继续向下一个前进，检查是否相等
                a++;
                b++;
            }
            if (b == n_len) return i;
        }
        return -1;
    }
}