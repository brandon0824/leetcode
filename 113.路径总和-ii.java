import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }

    public void recur(TreeNode root, int target) {
        if(root == null) return;
        path.add(root.val);
        target -= root.val;
        
        if(target == 0 && root.left == null && root.right == null){
            res.add(new LinkedList<Integer>(path));
        }
        recur(root.left, target);
        recur(root.right, target);
        path.removeLast();
    }
}
// @lc code=end

