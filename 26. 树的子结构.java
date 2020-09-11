/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // isSubStructure 查找A中以R为根节点的子树是不是和B一样结构
 // isAhasB A子树中是否有和B一样的节点R
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return false;
        }

        return isAhasB(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isAhasB(TreeNode A, TreeNode B){
        if(B == null){
            return true;
        }
        if(A == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        return isAhasB(A.left, B.left) && isAhasB(A.right, B.right);
    }
}