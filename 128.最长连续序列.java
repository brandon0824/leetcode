/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> hashset = new HashSet<Integer>();
        for(int i:nums){
            hashset.add(i);
        }
        for(int x:nums) {
            if(!hashset.contains(x - 1)){
                int temp = x;
                while(hashset.contains(temp + 1)) temp++;
                res = Math.max(res, temp - x + 1);
            }
        }
        return res;
    }
}
// @lc code=end

