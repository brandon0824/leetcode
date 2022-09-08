/*
 * @lc app=leetcode.cn id=224 lang=java
 *
 * [224] 基本计算器
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
        Deque<Integer> op = new LinkedList<Integer>();
        op.push(1);
        int sign = 1;

        int res = 0;
        int n = s.length();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == ' '){
                i++;
            }
            else if(s.charAt(i) == '+'){
                sign = op.peek();
                i++;
            }
            else if(s.charAt(i) == '-'){
                sign = -op.peek();
                i++;
            }
            else if(s.charAt(i) == '('){
                op.push(sign);
                i++;
            }
            else if(s.charAt(i) == ')'){
                op.pop();
                i++;
            }
            else{
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res; 
    }
}
// @lc code=end

