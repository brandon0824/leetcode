/*
 * @lc app=leetcode.cn id=394 lang=java
 *
 * [394] 字符串解码
 */

// @lc code=start
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()) {
            if(c != ']'){
                stack.push(c);
            }

            else{
                // 1.提取出[]内的字符串
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                stack.pop();
                String sub = sb.toString();

                // 2.获取倍数数字
                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb.toString());

                // 3.获取倍数把字母相乘后再push回去
                while(count > 0){
                    for(char ch : sub.toCharArray()){
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.insert(0, stack.pop());
        }
        return res.toString();
    }
}
// @lc code=end

