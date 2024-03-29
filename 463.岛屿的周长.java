/*
 * @lc app=leetcode.cn id=463 lang=java
 *
 * [463] 岛屿的周长
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int i, int j){

        // 从一个岛屿方格走向网格边界，周长加 1
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return 1;
        }
        // 从一个岛屿方格走向水域方格，周长加 1
        if(grid[i][j] == 0) return 1;

        // grid[i][j] == 2时返回 禁止重复计算(兜圈子)
        if(grid[i][j] != 1) return 0;

        grid[i][j] = 2;
        return dfs(grid, i - 1, j) + dfs(grid, i + 1, j)
            + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
    }
}
// @lc code=end

