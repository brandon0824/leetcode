/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 2;
        while(i >= 0){
            if(nums[i] < nums[i+1]) break;
            i--;
        }
        System.out.println(i);
        if(i >= 0){
            int j = len - 1;
            while(j > i){
                if(nums[j] > nums[i]) break;
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, len-1);
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void reverse(int[] nums, int left, int right) {
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
// @lc code=end

