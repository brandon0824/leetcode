/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        int m = inorder.length;        
        if(m == 0 || m == 0 || m != n){
            return null;
        }

        Map<Integer, Integer> indexMap = new HashMap<>(n);
        for(int i = 0; i < n; i++){
            indexMap.put(inorder[i], i);
        }
        return constructTree(preorder, 0, n-1, indexMap, 0, n-1);
    }

    private TreeNode constructTree(int[] pre, int startPre, int endPre,
                Map<Integer, Integer> indexMap, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        
        int rootval = pre[startPre];
        TreeNode node = new TreeNode(rootval);
        int rootIndex = indexMap.get(rootval);
        node.left = constructTree(pre, startPre+1, rootIndex-startIn+startPre, 
                indexMap, startIn, rootIndex-1);
        node.right = constructTree(pre, rootIndex-startIn+startPre+1, 
                endPre, indexMap, rootIndex+1, endIn);
        return node;
    }
}
// @lc code=end

