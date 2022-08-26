/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    public int removeElement(int[] nums, int val) {
        int ans = 0;
        for(int num:nums){
            if(num != val){
                nums[ans] = num;
                ans++;
            }
        }
        return ans;
    }
}
// @lc code=end

