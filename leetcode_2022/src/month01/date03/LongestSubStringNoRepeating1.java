package month01.date03;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 执行用时： 87 ms , 在所有 Java 提交中击败了 10.37% 的用户
 * 内存消耗： 39.2 MB , 在所有 Java 提交中击败了 5.09% 的用户
 * 通过测试用例： 987 / 987
 */
class LongestSubStringNoRepeating1 {
    private Set<Character> charSet = new LinkedHashSet<>();
    int length = 0;

    public static void main(String[] args) {
        String s = "brnk";
        LongestSubStringNoRepeating1 solution = new LongestSubStringNoRepeating1();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                int curLen = container(s.charAt(j));
                length = length > curLen ? length : curLen;
                if(curLen == -1) {
                    break;
                }
            }
        }
        return length;
    }

    public int container(char c) {
        if(charSet.contains(c)) {
            System.out.println(charSet);
            charSet.clear();
            return -1;
        } else {
            charSet.add(c);
            return charSet.size();
        }
    }
}