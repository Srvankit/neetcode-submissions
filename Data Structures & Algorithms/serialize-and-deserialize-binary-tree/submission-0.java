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

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb) {

        if(root == null){
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Deserialize
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        int[] index = new int[1];

        return deserializeHelper(values, index);
    }

    public TreeNode deserializeHelper(String[] values, int[] index) {

        if(values[index[0]].equals("#")){
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(
            Integer.parseInt(values[index[0]])
        );

        index[0]++;

        root.left = deserializeHelper(values, index);

        root.right = deserializeHelper(values, index);

        return root;
    }
}