package month01.date03;


/**
 * 执行用时： 2 ms , 在所有 Java 提交中击败了 96.99% 的用户
 * 内存消耗： 38.1 MB , 在所有 Java 提交中击败了 96.41% 的用户
 * 通过测试用例： 987 / 987
 */
class Solution {

    public static void main(String[] args) {
        String s = "addgedssassgasdgqtreqrey";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /*
    记录每个字符出现的位置，并对比本次位置与上次位置，得出最大值
     */
    public static int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            // 每个字符对应索引中的一个位置
            int index = s.charAt(i);
            // 窗口
            start = Math.max(start, last[index] + 1);
            // 最大
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}