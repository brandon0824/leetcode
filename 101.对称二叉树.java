/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null){
            return true;
        }
        if(pRoot1 == null || pRoot2 == null){
            return false;
        }
        if(pRoot1.val != pRoot2.val){
            return false;
        }
        return isSymmetric(pRoot1.left, pRoot2.right) && isSymmetric(pRoot1.right, pRoot2.left);
    }
}
// @lc code=end

