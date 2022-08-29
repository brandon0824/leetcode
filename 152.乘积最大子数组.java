/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int maxnum = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            maxnum = Math.max(maxnum, imax);
        }
        return maxnum;
    }
}
// @lc code=end

