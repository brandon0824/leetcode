/*
 * @lc app=leetcode.cn id=343 lang=java
 *
 * [343] 整数拆分
 */

// @lc code=start
class Solution {
    public int integerBreak(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <= n; i++){
            for(int k = 1; k <= i-1; k++){
                int tmp = Math.max(k*dp[i-k], k*(i-k));
                dp[i] = Math.max(tmp, dp[i]);
            }
        }
        return dp[n];
    }
}
// @lc code=end

