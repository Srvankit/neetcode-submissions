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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> ans = Inorder(root);

        return ans.get(k - 1);
    }

    public List<Integer> Inorder(TreeNode root) {

        List<Integer> ls = new ArrayList<>();

        if(root == null){
            return ls;
        }

        ls.addAll(Inorder(root.left));

        ls.add(root.val);

        ls.addAll(Inorder(root.right));

        return ls;
    }
}