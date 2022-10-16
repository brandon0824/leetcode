import java.util.Deque;

/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0) return res;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
    public void dfs(int[] candidates, int len, int begin, 
            int target, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = begin; i < len; i++){
            if(target - candidates[i] < 0) break;
            if(i > begin && candidates[i] == candidates[i - 1]) continue;
            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
// @lc code=end

