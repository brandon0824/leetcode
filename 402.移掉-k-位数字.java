import java.util.Deque;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        for(int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        
        // testcase: num = "9" k = 1 expect:"0" answer:"9" deque中只有9
        // 为了应对这种情况 删除了0个数字但0 < k 需要从序列尾部删除额外的 (k - m) 个数字
        for(int i = 0; i < k; i++) {
            deque.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while(!deque.isEmpty()){
            char digit = deque.pollFirst();
            if(leadingZero && digit == '0'){
                continue;
            }
            leadingZero = false;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
// @lc code=end

