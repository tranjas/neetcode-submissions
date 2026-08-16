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
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        int[] result = new int[1];
        dfs(root, result, root.val);
        return result[0];
    }

    public void dfs(TreeNode root, int[] result, int max) {
        if (root == null) return;
        if (root.val >= max) result[0]++;
        dfs(root.left, result, Math.max(root.val, max));
        dfs(root.right, result, Math.max(root.val, max));
    }
}
