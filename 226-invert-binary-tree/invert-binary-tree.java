
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//        if(root ==null) return null ;
 
//     final Queue<TreeNode> queue = new LinkedList<>();
//     queue.add(root);

//     while(!queue.isEmpty()){
//         final TreeNode temp = queue.poll() ;

//         // swap nodes 
//         final TreeNode temp =TreeNode.left;
//          TreeNode.left = TreeNode.right;
//         TreeNode.right = temp;

//         if(TreeNode.left!=null)  queue.add(TreeNode.left);
//            if(TreeNode.right!=null)  queue.add(TreeNode.right);

//     }
//     return root ; 
//     }
// }

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        TreeNode temp =root.left;
        root.left=root.right;
        root.right=temp;

        root.left=invertTree(root.left);
        root.right=invertTree(root.right);
        return root ;
    }
}