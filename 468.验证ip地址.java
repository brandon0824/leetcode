/*
 * @lc app=leetcode.cn id=468 lang=java
 *
 * [468] 验证IP地址
 */

// @lc code=start
class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.indexOf('.') >= 0){
            return isipv4(queryIP) ? "IPv4" : "Neither";
        }else{
            return isipv6(queryIP) ? "IPv6" : "Neither";
        }
    }

    public boolean isipv4(String queryIP) {
        //172.168.0.1 -> 172 168 0 1
        String[] split = queryIP.split("\\.", -1);
        if(split.length != 4) return false;
        for(String s : split) {
            if(s.length() > 3 || s.length() == 0){
                return false;
            }
            if(s.charAt(0) == '0' && s.length() != 1){
                return false;
            }
            int ans = 0;
            for(int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if(!Character.isDigit(c)){
                    return false;
                }
                ans = ans * 10 + (c - '0');
            }
            if(ans > 255) return false;
        }
        return true;
    }

    public boolean isipv6(String queryIP) {
        //2001:0db8:85a3:0:0:8A2E:0370:7334
        String[] split = queryIP.split(":", -1);
        if(split.length != 8) return false;
        for(String s : split){
            if(s.length() > 4 || s.length() == 0){
                return false;
            }
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!Character.isDigit(c) && !(Character.toLowerCase(c) >= 'a') || !(Character.toLowerCase(c) <= 'f')){
                    return false;
                }
            }
        }
        return true;
    }

}
// @lc code=end

