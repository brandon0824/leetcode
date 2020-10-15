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
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[0];
        }
        Queue<TreeNode> q = new LinkedList<>(); 
        ArrayList<Integer> tmp =new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            tmp.add(node.val);
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
        }
        int[] res = new int[tmp.size()];
        for(int i = 0; i < tmp.size(); i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
}