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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If left is null, return 1 + depth of right subtree
        if (root.left == null) return 1 + minDepth(root.right);

        // If right is null, return 1 + depth of left subtree
        if (root.right == null) return 1 + minDepth(root.left);

        // Both children exist
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
