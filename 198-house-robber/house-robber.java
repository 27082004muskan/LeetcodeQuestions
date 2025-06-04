class Solution {
    // public int rob(int[] nums) {
    //    int count=0;
    //    int maxCount=0;
    //    int n =nums.length;
    //    for(int i =0;i<n;i++){
    //     for(int j =i+2;j<n;j++){
    //      count=nums[i]+nums[j];
    //      maxCount=Math.max(count , maxCount);
    //     }
    //    } 
    //    return maxCount;




    //        int count=0;
    //    int maxCount=0;
    //    int n =nums.length;
    //    for(int i =2;i<n;i++){
       
    //      count=nums[i-2]+nums[i];
    //      maxCount=Math.max(count , maxCount);
        
    //    } 
    //    return maxCount;


//     public int rob(int[] nums) {
//         int n = nums.length;
//         return robHelper(nums, n - 1);  
//     }

//     private int robHelper(int[] nums, int ind) {
//         if (ind < 0) return 0; 
//         if (ind == 0) return nums[0]; 
        
      
//         return Math.max(nums[ind] + robHelper(nums, ind - 2), robHelper(nums, ind - 1));
//     }
// }

public int rob(int[] nums) {
    int n = nums.length;
    int[] memo = new int[n];
    Arrays.fill(memo, -1);
    return robHelper(nums, n - 1, memo);
}

private int robHelper(int[] nums, int ind, int[] memo) {
    if (ind < 0) return 0;
    if (ind == 0) return nums[0];
    if (memo[ind] != -1) return memo[ind];
    
    int robCurrent = nums[ind] + robHelper(nums, ind - 2, memo);
    int skipCurrent = robHelper(nums, ind - 1, memo);
    
    memo[ind] = Math.max(robCurrent, skipCurrent);
    return memo[ind];
}
}
