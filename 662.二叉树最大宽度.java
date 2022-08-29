/*
 * @lc app=leetcode.cn id=662 lang=java
 *
 * [662] 二叉树最大宽度
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
    Map<Integer, Integer> levelmin = new HashMap<Integer, Integer>();
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 1, 1);
    }

    public int dfs(TreeNode node, int depth, int index){
        if(node == null) return 0;
        levelmin.putIfAbsent(depth, index);

        return Math.max(
            index - levelmin.get(depth) + 1, 
            Math.max(dfs(node.left, depth + 1, index * 2), 
                    dfs(node.right, depth + 1, index * 2 + 1))
        );
    }
}
// @lc code=end

