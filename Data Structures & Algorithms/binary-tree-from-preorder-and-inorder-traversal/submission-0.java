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
    int preorderidx =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode build(int[]preorder, int[]inorder, int left, int right){
        if(left > right){
            return null;
        }
        int rootval = preorder[preorderidx];
        preorderidx++;

        TreeNode root = new TreeNode(rootval);

        int rootidx = left;
        
        while(inorder[rootidx] != rootval){
            rootidx++;
        }

        root.left = build(preorder, inorder, left, rootidx-1);
        root.right = build(preorder, inorder, rootidx+1, right);

        return root;
    }
}
