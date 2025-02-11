// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//        int n =nums.length;
     
//        for(int i =0;i<n;i++){
//           int sum=0;
//         for(int j =i;j<n;j++){
//             sum=sum+nums[j];
//             if((j-i)>=1 && sum%k==0){
//                 return true;
//             }
//         }
//        } 
//        return false;
//     }
// }
import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // To handle cases where the subarray starts from index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            // Handle negative remainder case (e.g., if k is negative)
            if (remainder < 0) remainder += k;

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) >= 2) {  // Ensure subarray length is at least 2
                    return true;
                }
            } else {
                map.put(remainder, i); // Store the first occurrence of the remainder
            }
        }
        return false;
    }
}
