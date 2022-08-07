/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        StringBuffer sb = new StringBuffer();
        int top = -1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(top >= 0 && sb.charAt(top) == ch) {
                sb.deleteCharAt(top);
                top--;
            }
            else{
                sb.append(ch);
                top++;
            }
        }
        return sb.toString();
    }
}
// @lc code=end

