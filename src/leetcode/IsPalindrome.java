package leetcode;
/**
 * 校验一个整数是否为回文数
 * 因为需要保证正反都是一样的数字 121  232 434
 * 所以只要将数字反转，然后比较反转的数字和原来的数字是否相等即可
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int num = 1221;
        System.out.println(isPalindrome(num));
        
        
    }
    
    public static boolean isPalindrome(int num) {
        if (num < 0) return false;
        int reverse = 0;
        int tmp = num;

        int len = String.valueOf(tmp).length();
        for (int i = 0; i < len; i++) {
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }
        return reverse == num;
    }
}
