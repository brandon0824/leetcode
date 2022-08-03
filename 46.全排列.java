import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int length = nums.length;
        if(length == 0) return res;

        boolean[] used = new boolean[length];
        List<Integer> path = new ArrayList<>();
        dfs(nums, length, 0, path, used, res);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, 
        List<Integer> path, boolean[] used, List<List<Integer>> res){
            if(len == depth){
                res.add(new ArrayList<>(path));
                return;
            }
            for(int i = 0; i < len; i++){
                if(!used[i]){
                    path.add(nums[i]);
                    used[i] = true;
                    dfs(nums, len, depth + 1, path, used, res);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
}
// @lc code=end

