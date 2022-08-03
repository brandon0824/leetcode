/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom){
            for(int column = left; column <= right; column++){
                result.add(matrix[top][column]);
            }
            for(int row = top + 1; row <= bottom; row++){
                result.add(matrix[row][right]);
            }
            //if(left < right && top < bottom){
                for(int column = right - 1; column > left; column--){
                    result.add(matrix[bottom][column]);
                }
                for(int row = bottom; row > top; row--){
                    result.add(matrix[row][left]);
                }
            //}
            left++;right--;top++;bottom--;
        }
        return result;
    }
}
// @lc code=end

