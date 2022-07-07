/*
 * @lc app=leetcode.cn id=704 lang=java
 *
 * [704] 二分查找
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int middle = (high - low) / 2 + low;
            int num = nums[middle];
            if(num == target){
                return middle;
            }
            else if(num < target){
                low = middle + 1;
            }
            else{
                high = middle - 1;
            }
        }
        return -1;
    }
}
// @lc code=end

