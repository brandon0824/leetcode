/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int x = 0; x < m; x++){
            dp[x][0] = 1;
        }
        for(int y = 0; y < n; y++){
            dp[0][y] = 1;
        }
        for(int x = 1; x < m; x++){
            for(int y = 1; y < n; y++){
                dp[x][y] = dp[x-1][y] + dp[x][y-1];
            }
        }
        return dp[m-1][n-1];
    }
}
// @lc code=end

