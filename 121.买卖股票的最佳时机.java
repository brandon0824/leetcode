/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, cost = Integer.MAX_VALUE;
        for(int price:prices) {
            cost = Math.min(price, cost);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
// @lc code=end

