import java.util.Collections;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isOrderLeft = true;

        while(!queue.isEmpty()) {
            Deque<Integer> value = new LinkedList<Integer>();
            int currentLevel = queue.size();
            for(int i = 0; i < currentLevel; i++){
                TreeNode node = queue.poll();
                if(isOrderLeft){
                    value.offerLast(node.val);
                }else{
                    value.offerFirst(node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(new LinkedList<Integer>(value));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
// @lc code=end

