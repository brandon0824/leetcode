/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int k = 0;
        for(int i = 0; i <= k; i++){
            int temp = i + nums[i];
            k = Math.max(k, temp);
            if(k >= nums.length - 1) return true;
        }
        return false;
    }
}
// @lc code=end

