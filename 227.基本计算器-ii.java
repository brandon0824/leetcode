/*
 * @lc app=leetcode.cn id=227 lang=java
 *
 * [227] 基本计算器 II
 */

// @lc code=start
class Solution {
    Stack<Integer> num = new Stack<Integer>();
    Stack<Character> op = new Stack<Character>();
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public int calculate(String s) {
        // 处理第一位是负号的情况
        s = '0' + s;
        // 定义优先级
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') continue;
            if(c >= '0' && c <= '9'){// c是数字
                int x = 0;
                while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                    x = x * 10 + s.charAt(i++) - '0';
                }
                i--;
                num.add(x);
            }
            else{// c是操作符
                while(!op.isEmpty() && map.get(op.peek()) >= map.get(c)){
                    eval();
                }
                op.add(c);
            }
        }
        while(!op.isEmpty()) eval();
        return num.pop();
    }

    public void eval(){
        int b = num.pop();
        int a = num.pop();
        char c = op.pop();
        int res = 0;

        if(c == '+') res = a + b;
        else if(c == '-') res = a - b;
        else if(c == '*') res = a * b;
        else res = a / b;
        num.add(res);
    }
}
// @lc code=end

