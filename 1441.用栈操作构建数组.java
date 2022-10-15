/*
 * @lc app=leetcode.cn id=1441 lang=java
 *
 * [1441] 用栈操作构建数组
 */

// @lc code=start
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<String>();
        int pre = 0;
        for(int number:target) {
            for(int i = 0; i < number - pre - 1; i++) {
                result.add("Push");
                result.add("Pop");
            }
            result.add("Push");
            pre = number;
        }
        return result;
    }
}
// @lc code=end

