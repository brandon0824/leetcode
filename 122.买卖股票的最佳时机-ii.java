/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            int tmp = prices[i] - prices[i - 1];
            if(tmp > 0) {
                profit += tmp;
            }
        }
        return profit;
    }
}
// @lc code=end

