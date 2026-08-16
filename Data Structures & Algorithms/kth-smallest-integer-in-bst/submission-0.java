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
        Queue<Integer> heap = new PriorityQueue<>();
        dfs(root, heap);
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.peek();
    }

    public void dfs(TreeNode root, Queue<Integer> heap) {
        if (root == null) return;
        heap.add(root.val);
        dfs(root.left, heap);
        dfs(root.right, heap);
    }
}
