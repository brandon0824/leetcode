import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return new int[0][2];
        List<int[]> res = new ArrayList<int[]>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int i = 0;
        while(i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i < intervals.length - 1 && intervals[i + 1][0] <= right){
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
// @lc code=end

