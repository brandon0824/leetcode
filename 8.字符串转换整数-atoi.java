/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int len = s.length();
        if(len == 0) return 0;
        char[] charArray = s.toCharArray();
        
        // 去掉空格
        int index = 0;
        while(index < len && charArray[index] == ' '){
            index++;
        }
        if(index == len) return 0;
        
        // 记录正负值(如果有出现的话)
        int sign = 1;
        char firstChar = charArray[index];
        if(firstChar == '+'){
            index++;
        }else if(firstChar == '-'){
            index++;
            sign = -1;
        }

        // 判断数字是否合法
        int res = 0;
        while(index < len){
            char c = charArray[index];
            if(c < '0' || c > '9') break;

            //题目要求只能存储32位 那么必须在转的时候判断移除[-2^31, 2^31-1]
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }
}
// @lc code=end