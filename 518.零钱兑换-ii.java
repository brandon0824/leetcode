/*
 * @lc app=leetcode.cn id=518 lang=java
 *
 * [518] 零钱兑换 II
 */

// @lc code=start
class Solution {
    public int change(int amount, int[] coins) {
        //dp[x]:总价为x的组合数 最后求dp[amount]
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i = coin; i <= amount; i++){
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
// @lc code=end

