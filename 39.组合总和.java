import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if(len == 0) return result;
        dfs(candidates, target, result, path, 0, len);
        return result;
    }

    public void dfs(int[] candidates, int target, 
        List<List<Integer>> result, List<Integer> path, int idx, int length){
            if(target < 0){
                return;
            }
            if(target == 0){
                result.add(new ArrayList<Integer>(path));
                return;
            }
            for(int i = idx; i < length; i++){
                path.add(candidates[i]);
                System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
                
                //// 注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
                dfs(candidates, target - candidates[i], result, path, i, length);
                path.remove(path.size() - 1);
                System.out.println("递归之后 => " + path);
            }
    }
}
// @lc code=end

