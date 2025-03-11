
class Solution {
public TreeNode helper(int[] preorder , int prelow, int prehigh , int[] inorder , int inlow, int inhigh){
if(prelow>prehigh) return null;
TreeNode root = new TreeNode (preorder[prelow]);
int i =inlow;
while(inorder[i]!=preorder[prelow]) i++;
int leftsize = i-inlow;
root.left=helper(preorder, prelow+1,prelow+leftsize , inorder, inlow , i-1);
root.right=helper(preorder,prelow+leftsize+1,prehigh , inorder, i+1 , inhigh);
return root ;
}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n =preorder.length;
        return helper(preorder , 0,n-1, inorder , 0,n-1);
    }
}