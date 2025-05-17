// -----------------------ONLY RECURSION --------------


//  class Solution {

//     public boolean solve(int nums[] , int n , int idx){
//      if(idx==n-1) return true ;
//      if(idx>=n-1 ) return false ;

//      for(int i =1;i<=nums[idx];i++){
//         if(solve(nums , n , idx+i)== true){
//             return true ;
//         }
       
//      }
//       return false ;
//     }
//     public boolean canJump(int[] nums) {
//         int n = nums.length ;
//         return solve(nums , n , 0);
//     }
// }

// -----------------------MEMORIZATION -------------

class Solution {
    int[] memo;

    public boolean solve(int[] nums, int n, int idx) {
        if (idx == n - 1) return true;
        if (idx >= n) return false;
        if (memo[idx] != -1) return memo[idx] == 1;

        for (int i = 1; i <= nums[idx]; i++) {
            if (solve(nums, n, idx + i)) {
                memo[idx] = 1;
                return true;
            }
        }

        memo[idx] = 0;
        return false;
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, n, 0);
    }
}
