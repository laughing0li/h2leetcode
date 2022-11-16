package leetcode;

public class AddBinary {
    
    public static void main(String[] args) {
        String a = "1010" ,b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        // temp 表示是否是需要进位
        int temp = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = temp;
            // '0' 48 和 '1' 49 相距 1 
            // 当 i 或者 j 小于 0 了之后如果就将其置为0
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            // 需要百分比，是因为需要处理进位
            sb.append(sum % 2);
            // 当前是否需要进位
            temp = sum / 2;
        }
        sb.append(temp == 1 ? temp : "");
        // 因为是从字符串的最后开始计算然后添加到sb。所以需要反转
        return sb.reverse().toString();
    }
    
}
