package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 */
public class LetterCombinations {

    List<String> results = new ArrayList<>();
    String[] letter_map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        String digits = "23234";
        System.out.println(lc.letterCombinations(digits));
    }
    public List<String> letterCombinations(String digits) {
        
        if (digits == null || digits.length() == 0) return  results;
        iterStr(digits, new StringBuilder(), 0);
        return results;
    }

    /**
     * 
     * @param str 传入的数字字符串
     * @param letter 
     * @param index 用于标识当前是字符串中的第几个字符
     * @param res 用于接收所有的答案数据
     */
    public void iterStr(String str, StringBuilder letter, int index) {
        if (index == str.length()) {
            results.add(letter.toString());
            return;
        }
        char c = str.charAt(index);
        // 字符 '2' - 字符'0' 就等于数字2. 这里作用是将字符转为数字
        int pos = c - '0';
        // 因为pos是对应的letter_map的下标，所以第一个是2 那么对于map_string就是 "abc"
        String map_string = letter_map[pos];
        // 遍历"abc" 将他们分别与后面字符 进行拼接
        for (int i = 0; i < map_string.length(); i++) {
            letter.append(map_string.charAt(i));
            // 这里就是最关键的地方，是会根据数字字符串的长度来进行几次。如果是"23" 就只会进入一次
            // letter.append 之后 直接进入递归 
            iterStr(str, letter, index + 1);
            // 第一次当结束iterStr方法后 letter会是"ad" 如果不将d删除
            // 那么第二次的时候 就会变成adf
            // 第三次就会变成adfe。后面会越来越长。所以需要每次递归结束后去掉最后一个
            letter.deleteCharAt(letter.length() - 1);
        }
    }
}
