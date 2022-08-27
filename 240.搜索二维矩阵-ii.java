/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(matrix == null || rows == 0 || cols == 0) return false;
        
        int row = 0, col = cols - 1;
        while(row < rows && col >= 0){
            int num = matrix[row][col];
            if(num == target){
                return true;
            }
            else if(num < target){
                row++;
            }
            else{
                col--;
            }
        }
        return false;
    }
}
// @lc code=end

