/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1, tar = n*n;
        while(num <= tar){
            for(int i = left; i <= right; i++){
                matrix[top][i] = num++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                matrix[i][right] = num++;
            }
            right--;
            for(int i = right; i >= left; i--){
                matrix[bottom][i] = num++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                matrix[i][left] = num++;
            }
            left++;
        }
        return matrix;
    }
}
// @lc code=end

