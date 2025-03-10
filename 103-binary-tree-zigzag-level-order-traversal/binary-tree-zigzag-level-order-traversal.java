
// class Solution {
//     public int height(TreeNode root){
//         if(root==null ||(root.left ==null && root.right==null)) return 0 ;
//         return 1 +Math.max(height(root.left) , height(root.right));
//     }
//     public void nthLevel(TreeNode root , int n ,List<Integer> arr ){
//         if(root==null) return ;
//         if(n==1){
//             arr.add(root.val);
//             return ;
//         }
//         nthLevel(root.left,n-1 ,arr);
//         nthLevel(root.right,n-1,arr);
//     }
//       public void nthLevel2(TreeNode root , int n ,List<Integer> arr ){
//         if(root==null) return ;
//         if(n==1){
//             arr.add(root.val);
//             return ;
//         }
//          nthLevel2(root.right,n-1,arr);
//         nthLevel2(root.left,n-1,arr);
       
//     }
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         int level = height(root);
//         List<List<Integer>> ans = new ArrayList<>();
//         if(root==null) return ans ;
//         for(int i =0;i<=level;i++){
//             List<Integer> arr = new ArrayList<>();
//             if(i%2==0) nthLevel(root,i,arr);
//             else nthLevel2(root, i,arr);
//             ans.add(arr);
//         }
//         return ans;
//     }
// }
class Solution {
    // Function to find the height of the tree
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

    // Function to get nodes at nth level (right to left)
    public void nthLevel2(TreeNode root, int n, List<Integer> arr) {
        if (root == null) return;
        if (n == 1) {
            arr.add(root.val);
            return;
        }
        nthLevel2(root.right, n - 1, arr);
        nthLevel2(root.left, n - 1, arr);
    }

    // Function to return zigzag level order traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(); // Fix: Handle null case before height calculation

        int level = height(root);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= level + 1; i++) { // Fix: Ensure levels start from 1
            List<Integer> arr = new ArrayList<>();
            if (i % 2 != 0) nthLevel(root, i, arr);  // Left to right for odd levels
            else nthLevel2(root, i, arr);           // Right to left for even levels
            ans.add(arr);
        }
        return ans;
    }
}