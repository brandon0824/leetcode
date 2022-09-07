import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] req = data.split(",");
        //Arrays.asList 数组 -> 集合
        ArrayList<String> res = new ArrayList<>(Arrays.asList(req));
        return dfsdeserialize(res);
    }

    public TreeNode dfsdeserialize(ArrayList<String> r){
        if("null".equals(r.get(0))){
            r.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(r.get(0)));
        r.remove(0);
        node.left = dfsdeserialize(r);
        node.right = dfsdeserialize(r);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

