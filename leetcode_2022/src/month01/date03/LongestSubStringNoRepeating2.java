package month01.date03;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 执行用时： 5 ms , 在所有 Java 提交中击败了 79.27% 的用户
 * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 30.01% 的用户
 * 通过测试用例： 987 / 987
 */
class LongestSubStringNoRepeating2 {
    private Map<Character, Integer> window = new LinkedHashMap<>();
    int length = 0;
    int left = 0;

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubStringNoRepeating2 solution = new LongestSubStringNoRepeating2();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if(window.containsKey(c)) {
                left = Math.max(left, window.get(c) + 1);
            }
            window.put(c, i);
            length = Math.max(length, i - left + 1);
        }
        return length;
    }

}