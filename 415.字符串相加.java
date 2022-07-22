/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, flag = 0;
        StringBuffer sb = new StringBuffer("");
        while(i >= 0 || j >= 0){
            int n1 = i >= 0? num1.charAt(i) - '0': 0;
            int n2 = j >= 0? num2.charAt(j) - '0': 0;
            int tmp = n1 + n2 + flag;
            flag = tmp / 10;
            sb.append(tmp%10);
            i--;j--;
        }
        if(flag == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
// @lc code=end

