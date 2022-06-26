import java.util.Random;

/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        return QuickSort(nums, k, 0, nums.length-1);
    }

    public int QuickSort(int[] nums, int k, int low, int high) {
        int index = rand.nextInt(high-low+1) + low;
        int flag = nums[index];
        nums[index] =nums[low];
        int i = low, j = high;
        while(i < j){
            while(i < j && nums[j] >= flag) j--;
            nums[i] = nums[j];
            while(i < j && nums[i] <= flag) i++;
            nums[j] = nums[i];
        }
        nums[i] = flag;
        if(i == nums.length-k) return nums[i];
        else if(i < nums.length-k) return QuickSort(nums, k, i+1, high);
        else return QuickSort(nums, k, low, i-1);
    }
}
// @lc code=end
