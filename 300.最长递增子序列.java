import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=300 lang=java
 *
 * [300] 最长递增子序列
 */

// @lc code=start
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int[] arr = new int[len];
        arr[0] = nums[0];
        int res = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] > arr[res-1]){
                arr[res] = nums[i];
                res++;
                continue;
            }
            int left = 0, right = res - 1, mid;
            while(left <= right){
                mid = left + (right - left) / 2;
                if(arr[mid] >= nums[i]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            arr[left] = nums[i];
        }
        return res;
    }
}
// @lc code=end

