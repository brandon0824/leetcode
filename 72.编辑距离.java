/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++){// 插入
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for(int j = 1; j <= len2; j++){
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
                }
            }
        }
        return dp[len1][len2];
    }
}
// @lc code=end

