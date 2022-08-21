/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {//456+77
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder("");
        while(i >= 0 || j >= 0){
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;//6
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;//7
            int tmp = n1 + n2 + flag;//13
            flag = tmp / 10;
            sb.append(tmp % 10);
            i--;j--;
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

