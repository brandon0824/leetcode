import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrace(nums, res, 0, path, used);
        return res;
    }
    public void backtrace(int[] nums, List<List<Integer>> res, int idx,
        List<Integer> path, boolean[] used) {
        if(idx == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i > 0 && nums[i] == nums[i - 1] && used[i - 1])){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrace(nums, res, idx + 1, path, used);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

