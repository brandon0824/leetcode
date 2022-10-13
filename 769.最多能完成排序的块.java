/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int res = 0, m = 0;
        for(int i = 0; i < arr.length; i++) {
            m = Math.max(m, arr[i]);
            if(i == m) res++;
        }
        return res;
    }
}
// @lc code=end

