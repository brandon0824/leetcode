/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int prenum = getValue(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            int num = getValue(s.charAt(i));
            if(prenum < num){
                sum -= prenum;
            }
            else{
                sum += prenum;
            }
            prenum = num;
        }
        sum += prenum;
        return sum;
    }
    
    public int getValue(char ch){
        switch(ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
}
// @lc code=end

