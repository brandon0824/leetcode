/*
 * @lc app=leetcode.cn id=198 lang=java
 *
 * [198] 打家劫舍
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        if(len == 1) return nums[0];

        int[] dp = new int[len];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for(int i = 2; i < len; i++){
            //dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
// @lc code=end

