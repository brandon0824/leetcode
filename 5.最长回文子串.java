/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        int strlen = s.length();
        if(s == null || strlen < 2){
            return s;
        }

        int maxStart = 0, maxEnd = 0, maxLen = 1;
        boolean[][] dp = new boolean[strlen][strlen];

        for(int r = 1; r < strlen; r++){
            for(int l = 0; l < r; l++){
                if(s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l+1][r-1])){
                    //此处为了兼容 aa（r-l=1）和aba（r-l=2）这两种回文串 单独字符串已经判断了
                    dp[l][r] = true;
                    if(r - l + 1 > maxLen){
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }
}
// @lc code=end

