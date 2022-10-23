/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                swap(nums, i, ptr);
                ptr++;
            }
        }
        for(int i = ptr; i < n; i++){
            if(nums[i] == 1){
                swap(nums, i, ptr);
                ptr++;
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
// @lc code=end

