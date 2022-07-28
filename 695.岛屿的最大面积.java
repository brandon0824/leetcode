/*
 * @lc app=leetcode.cn id=695 lang=java
 *
 * [695] 岛屿的最大面积
 */

// @lc code=start
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int maxarea = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    area = getMaxArea(grid, i, j);
                    maxarea = Math.max(maxarea, area);
                }
            }
        }
        return maxarea;
    }

    public int getMaxArea(int[][] grid, int row, int col){
        if(row == grid.length || row < 0) return 0;
        if(col == grid[0].length || col < 0) return 0;
        if(grid[row][col] == 1){
            grid[row][col] = 0;
            return 1 + getMaxArea(grid, row-1, col) + getMaxArea(grid, row+1, col) +
                getMaxArea(grid, row, col-1) + getMaxArea(grid, row, col+1);
        }
        return 0;
    }
}
// @lc code=end

