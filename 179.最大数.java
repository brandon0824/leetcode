/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i = 0; i < str.length; i++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,(x, y) -> (y+x).compareTo(x+y));
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        String res = sb.toString();
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }
}
// @lc code=end

