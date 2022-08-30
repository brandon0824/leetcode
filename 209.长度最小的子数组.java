/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        int low = 0, high = 0, sum = 0;
        while(high < len){
            sum += nums[high++];
            while(sum >= target){
                min = Math.min(min, high - low);
                sum -= nums[low++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

