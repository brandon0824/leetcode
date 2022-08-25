/*
 * @lc app=leetcode.cn id=718 lang=java
 *
 * [718] 最长重复子数组
 */

// @lc code=start
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        int ans = 0;
        for(int i = len1-1; i >= 0; i--){
            for(int j = len2-1; j >= 0; j--){
                dp[i][j] = nums1[i] == nums2[j] ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]); 
            }
        }
        return ans;
    }
}
// @lc code=end

