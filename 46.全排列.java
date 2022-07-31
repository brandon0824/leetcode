import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(len == 0) return result;
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        backtrace(nums, len, 0, path, used, result);
        return result;
    }

    public void backtrace(int[] nums, int len, int depth, 
        List<Integer> path, boolean[] used, List<List<Integer>> result){
            if(depth == len){
                result.add(new ArrayList<Integer>(path));
                return;
            }
            for(int i = 0; i < len; i++){
                if(!used[i]){
                    path.add(nums[i]);
                    used[i] = true;
                    backtrace(nums, len, depth+1, path, used, result);
                    used[i] = false;
                    path.remove(path.size() - 1);
                }
            }
        }
}
// @lc code=end

