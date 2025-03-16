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
    public void flatten(TreeNode root) {
        if(root==null) return;
     //   if(root.left==null  && root.right==null) return ;
         TreeNode leftTree = root.left;
          TreeNode rightTree = root.right;
             root.left=null;
          flatten(leftTree);
          flatten(rightTree);
          root.right=leftTree;
          TreeNode temp=leftTree;
          while(temp!=null && temp.right!=null){
            temp=temp.right;
          }
          if(temp!=null) temp.right=rightTree;
          else root.right=rightTree;
          return ;

    }
}