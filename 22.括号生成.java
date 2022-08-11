/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> result = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, "");
        return result;
    }

    public void dfs(int n, int lc, int rc, String str){
        if(lc == n && rc == n){
            result.add(str);
        }
        else{
            if(lc < n) dfs(n, lc+1, rc, str+"(");
            if(rc < n && lc > rc) dfs(n, lc, rc+1, str+")");

        }
    }
}
// @lc code=end