/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int j;
        if(strs.length == 0) return "";
        String ans = strs[0];
        for(int i = 1; i < strs.length; i++) {
            for(j = 0; j < ans.length() && j < strs[i].length(); j++){
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0, j);
        }
        return ans;
    }
}
// @lc code=end

