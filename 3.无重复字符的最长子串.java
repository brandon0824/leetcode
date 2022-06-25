import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, n = s.length();
        if(n == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0, start = 0; end < n; end++){
            char letter = s.charAt(end);
            if(map.containsKey(letter)){
                start = Math.max(map.get(letter), start);
            }
            ans = Math.max(ans, end-start+1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
// @lc code=end

