/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {
        int num_island = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && visited[i][j] != 1){
                    dfs(grid, i, j, visited);
                    num_island++;
                }
            }
        }
        return num_island;
    }

    private void dfs(char[][] grid, int row, int col, int[][] visited){
        if(row >=  grid.length || col >= grid[0].length || row < 0 || col < 0
                || grid[row][col] == '0' || visited[row][col] == 1){
            return;
        }
        
        visited[row][col] = 1;
        dfs(grid, row-1, col, visited);
        dfs(grid, row+1, col, visited);
        dfs(grid, row, col-1, visited);
        dfs(grid, row, col+1, visited);

    }
}
// @lc code=end

