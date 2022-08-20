/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<Integer> tmp = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return res;
    }

    public void dfs(int[] nums, int cur){
        if(cur == nums.length){
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        tmp.add(nums[cur]);
        dfs(nums, cur + 1);
        tmp.remove(tmp.size() - 1);
        dfs(nums,cur + 1);
    }
}
// @lc code=end

