/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            sb.append((char)('A' + columnNumber % 26));
            columnNumber /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end

