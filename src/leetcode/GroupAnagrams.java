package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解题思路：先将字符串转换为字符数组，然后对字符数组进行排序。最后进行比较。
 * 
 */
public class GroupAnagrams {
    public static void main(String[] args) {
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            // 判断map里面是否含有当前的key
            if (map.containsKey(key) == false) {
                // 如果没有就创建一个键值对
                map.put(key, new ArrayList<>());
            }
            // 将字符串加入对应位置
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }
}
