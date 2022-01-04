package month01.date03;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 执行用时： 7 ms , 在所有 Java 提交中击败了 38.65% 的用户
 * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 40.08% 的用户
 * 通过测试用例： 987 / 987
 */
class LongestSubStringNoRepeating3 {
    private Map<Character, Integer> window = new LinkedHashMap<>();
    int length = 0;
    int left = 0;

    public static void main(String[] args) {
        String s = "abba";
        LongestSubStringNoRepeating3 solution = new LongestSubStringNoRepeating3();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(window.containsKey(s.charAt(i))) {
                left = Math.max(left, window.get(s.charAt(i)) + 1);
            }
            window.put(s.charAt(i), i);
            length = Math.max(length, i - left + 1);
        }
        return length;
    }

}