/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.right == null) return root.left;
            else if(root.left == null) return root.right;
            else if(root.left != null && root.right != null){
                TreeNode tmp = root.right;//6
                while(tmp.left != null){
                    tmp = tmp.left;//5
                }
                tmp.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
// @lc code=end

