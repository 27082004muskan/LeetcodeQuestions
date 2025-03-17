
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
          if(root==null){
            root=new TreeNode(val);
            return root;
        }
        // ****************************************** recursive approach 
        // if(val<root.val){
        //     root.left=insertIntoBST(root.left, val);
        // }else{
        //      root.right=insertIntoBST(root.right, val);
        // }
        // return root;

        //************************************************Iterative approach
        TreeNode temp = root;
        while(temp!=null){
        if(val<temp.val){
            if(temp.left==null){
                temp.left=new TreeNode(val);
                break;
            }
            else temp=temp.left;
        }else{
            if(temp.right==null){
                temp.right=new TreeNode(val);
                break;
            }
            else temp=temp.right;
        }
        }
        return root; 


    }
}