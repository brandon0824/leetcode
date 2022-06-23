/*
 * @lc app=leetcode.cn id=448 lang=java
 *
 * [448] 找到所有数组中消失的数字
 */

// @lc code=start
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        for(int num:nums){
            int x = (num - 1) % n;
            nums[x] += n;
        }
        for(int i = 0; i < n; i++){
            if(nums[i] <= n){
                res.add(i+1);
            }
            
        }
        return res;
    }
}
// @lc code=end

