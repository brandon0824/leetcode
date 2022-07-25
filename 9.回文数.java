/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int cur = 0, num = x;
        while(num != 0){
            cur = cur * 10 + num % 10;
            num = num/10;
        }
        return cur == x;
    }
}
// @lc code=end

