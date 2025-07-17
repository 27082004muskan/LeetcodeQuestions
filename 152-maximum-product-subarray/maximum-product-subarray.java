class Solution {
    public int maxProduct(int[] nums) {
      
        int n =nums.length;
        int maxProduct =Integer.MIN_VALUE;

        for(int i =0;i<n;i++){
            if(n==1) return nums[i];
           
            int product =1;
        for(int j=i;j<n;j++){
             product *=nums[j];
             maxProduct = Math.max(product , maxProduct);
        }
        }
        return maxProduct;
    }
}
