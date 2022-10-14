/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for(int i = 0; i < len; i++){
            while(!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                int index = deque.pollLast();
                res[index] = i - index;
            }
            deque.addLast(i);
        }
        return res;
    }
}
// @lc code=end

