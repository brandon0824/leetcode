/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0) return new int[]{-1, -1};

        int first = findFirstPosition(nums, target);
        if(first == -1) return new int[]{-1, -1};

        int last = findLastPosition(nums, target);
        return new int[]{first, last};
    }

    public int findFirstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] < target){
                // 下一轮在[mid+1, right]
                left = mid + 1;
            }else if(nums[mid] == target){
                // 下一轮在[left, mid]
                right = mid;
            }else{
                // 下一轮在[left, mid-1]
                right = mid - 1;
            }
        }
        if(nums[left] == target){
            return left;
        }
        return -1;
    }

    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right){
            // 这一步关键 取中间数行为上取整
            int mid = (left + right + 1) / 2;
            if(nums[mid] < target){
                // 下一轮在[mid+1, right]
                left = mid + 1;
            }else if(nums[mid] == target){
                // 下一轮在[mid,right]
                left = mid;
            }else{
                // 下一轮在[left, mid-1]
                right = mid - 1;
            }
        }
        return left;
    }
}
// @lc code=end

