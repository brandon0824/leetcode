/*
 * @lc app=leetcode.cn id=125 lang=java
 *
 * [125] 验证回文串
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int left = 0, right = c.length - 1;
        while(left < right) {
            while(left < right && !isValid(c[left])){
                left++;
            }
            while(left < right && !isValid(c[right])){
                right--;
            }
            if(c[left] != c[right]){
                return false;
            }
            left++;right--;
        }
        return true;
    }

    public boolean isValid(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
// @lc code=end

