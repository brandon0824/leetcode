/*
 * @lc app=leetcode.cn id=581 lang=java
 *
 * [581] 最短无序连续子数组
 */

// @lc code=start
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (isSorted(nums))
            return 0;
        int[] nums_sorted = new int[nums.length]; 
        System.arraycopy(nums, 0, nums_sorted, 0, nums.length);
        Arrays.sort(nums_sorted);
        int left = 0, right = nums.length - 1;
        while(nums[left] == nums_sorted[left]){
            left++;
        }
        while(nums[right] == nums_sorted[right]){
            right--;
        }
        return right-left+1;
    }


    public boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
