/*
 * @lc app=leetcode.cn id=958 lang=java
 *
 * [958] 二叉树的完全性检验
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
    int size = 0;//实际节点数
    int max = 0;//数组长度
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        recur(root, 1);
        return size == max;
    }

    public void recur(TreeNode root, int index) {
        if(root == null) return;
        size++;
        max = Math.max(max, index);
        recur(root.left, index * 2);
        recur(root.right, index * 2 + 1);
    }
}
// @lc code=end

