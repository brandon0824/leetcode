/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = trimspace(s);
        reverse(sb, 0, sb.length() - 1);
        reverseWord(sb);
        return sb.toString();
    }

    public StringBuilder trimspace(String s){
        StringBuilder sb = new StringBuilder();
        int left = 0, right = s.length() - 1;
        
        //去掉前后的空格
        while(left <= right && s.charAt(left) == ' '){
            left++;
        }
        while(left <= right && s.charAt(right) == ' '){
            right--;
        }

        // 去掉字符串间多余的空格
        while(left <= right){
            char c = s.charAt(left);
            if(c != ' '){
                sb.append(c);
            }
            // 碰到空格了
            else if(sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        // 对StringBuilder中从left到right的字符串进行逆序
        while(left < right){
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseWord(StringBuilder sb){
        // 对单个单词进行逆序
        int n = sb.length();
        int start = 0, end = 0;
        while(start < n){
            while(end < n && sb.charAt(end) != ' ') end++;
            reverse(sb, start, end - 1);
            start = end + 1;
            end++;
        }
    }
}
// @lc code=end

