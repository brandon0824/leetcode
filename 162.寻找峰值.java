/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                // 下一次范围变成[left, mid]
                right = mid;
            }else{
                // 下一次范围变成[mid+1, right]
                left = mid + 1;
            }
        }
        return left;
    }
}
// @lc code=end

