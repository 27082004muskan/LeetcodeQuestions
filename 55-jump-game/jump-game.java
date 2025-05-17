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

// class Solution {
//     int[] memo;

//     public boolean solve(int[] nums, int n, int idx) {
//         if (idx == n - 1) return true;
//         if (idx >= n) return false;
//         if (memo[idx] != -1) return memo[idx] == 1;

//         for (int i = 1; i <= nums[idx]; i++) {
//             if (solve(nums, n, idx + i)) {
//                 memo[idx] = 1;
//                 return true;
//             }
//         }

//         memo[idx] = 0;
//         return false;
//     }

//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         memo = new int[n];
//         Arrays.fill(memo, -1);
//         return solve(nums, n, 0);
//     }
// }

//------------------------BOTTOM UP ----------------

// class Solution {
//     public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean[] t = new boolean[n];
//         t[0] = true; // Starting position is reachable

//         for (int i = 1; i < n; i++) {
//             for (int j = i - 1; j >= 0; j--) {
//                 if (j + nums[j] >= i && t[j]) {
//                     t[i] = true;
//                     break;
//                 }
//             }
//         }

//         return t[n - 1];
//     }
// }

//----------------OPTIMAL ---------------

class Solution {
    public boolean canJump(int[] nums) {
        int maxReachable =0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(i>maxReachable ){
                return false ;
            }
            maxReachable = Math.max(maxReachable , nums[i]+i);
        }
        return true ;
    }
}
