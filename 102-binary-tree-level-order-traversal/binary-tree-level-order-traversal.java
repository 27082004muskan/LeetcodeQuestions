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

     public int height(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Function to get nodes at nth level (left to right)
    public void nthLevel(TreeNode root, int n, List<Integer> arr) {
        if (root == null) return;
        if (n == 1) {
            arr.add(root.val);
            return;
        }
        nthLevel(root.left, n - 1, arr);
        nthLevel(root.right, n - 1, arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
          if (root == null) return new ArrayList<>(); // Fix: Handle null case before height calculation

        int level = height(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= level + 1; i++) { // Fix: Ensure levels start from 1
            List<Integer> arr = new ArrayList<>();
            nthLevel(root, i, arr);  // Left to right for odd levels
            ans.add(arr);
        }
        return ans;
    }
}