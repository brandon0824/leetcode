/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        for(int i = num2.length() - 1; i >= 0; i--){
            int flag = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < num2.length() - i - 1; j++){
                sb.append(0);
            }
            int n2 = num2.charAt(i) - '0';
            for(int j = num1.length() - 1; j >= 0 || flag != 0; j--){
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + flag) % 10;
                sb.append(product);
                flag = (n1 * n2 + flag) / 10;
            }
            res = addStrings(res, sb.reverse().toString());
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        // 对两个字符串进行相加 leetcode-415
        int i = num1.length() - 1, j = num2.length() - 1, flag = 0;
        StringBuffer sb = new StringBuffer("");
        while(i >= 0 || j >= 0){
            int n1 = i >= 0? num1.charAt(i) - '0': 0;
            int n2 = j >= 0? num2.charAt(j) - '0': 0;
            int tmp = n1 + n2 + flag;
            flag = tmp / 10;
            sb.append(tmp%10);
            i--;j--;
        }
        if(flag == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
// @lc code=end

