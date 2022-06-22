/*
 * @lc app=leetcode.cn id=169 lang=java
 *
 * [169] 多数元素
 */

// @lc code=start
class Solution {
    public int majorityElement(int[] nums) {
        int x = 0, count = 0, votes = 0;
        for(int num: nums) {
            if(votes == 0) x = num;
            votes += x == num ? 1 : -1;
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == x) count++;
        }
        return count > nums.length / 2 ? x : 0;
    }
}
// @lc code=end

