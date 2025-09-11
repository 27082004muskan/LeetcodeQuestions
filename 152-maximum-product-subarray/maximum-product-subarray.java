// class Solution {
//     public int maxProduct(int[] nums) {
      
//         int n =nums.length;
//         int maxProduct =Integer.MIN_VALUE;

//         for(int i =0;i<n;i++){
//             if(n==1) return nums[i];
           
//             int product =1;
//         for(int j=i;j<n;j++){
//              product *=nums[j];
//              maxProduct = Math.max(product , maxProduct);
//         }
//         }
//         return maxProduct;
//     }
// }

class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            
            // Store maxSoFar before updating
            int tempMax = Math.max(curr, Math.max(maxSoFar * curr, minSoFar * curr));
            minSoFar = Math.min(curr, Math.min(maxSoFar * curr, minSoFar * curr));
            maxSoFar = tempMax;
            
            result = Math.max(result, maxSoFar);
        }
        
        return result;
    }
}

