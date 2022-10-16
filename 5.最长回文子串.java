/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int strlen = s.length();
        if(s == null || strlen == 0){
            return "";
        }
        int left = 0, right = 0;
        int len = 1, maxStart = 0, maxLen = 0;
        for(int i = 0; i < strlen; i++){
            left = i - 1;
            right = i + 1;
            while(left >= 0 && s.charAt(i) == s.charAt(left)){
                left--;len++;
            }
            while(right < strlen && s.charAt(i) == s.charAt(right)){
                right++;len++;
            }
            while(left >= 0 && right < strlen && s.charAt(left) == s.charAt(right)){
                left--;right++;
                len += 2;            
            }
            if(len > maxLen){
                maxLen = len;
                maxStart = left;
            }
            
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
// @lc code=end

