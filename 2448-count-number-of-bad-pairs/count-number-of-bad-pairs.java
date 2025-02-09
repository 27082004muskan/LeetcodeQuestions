// class Solution {
//     public long countBadPairs(int[] nums) {
//         long count=0;
//         int n =nums.length;
//         for(int i =0;i<n-1;i++){
//             for(int j=i+1;j<n;j++){
//                   if(j - i != nums[j] - nums[i] ){
//                     count++;
//                   }
//             }
//         }
//         return count;
//     }
// }
import java.util.HashMap;

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(nums[0], 1);

        for (int j = 1; j < n; j++) {
            int countOfNumsJ = mp.getOrDefault(nums[j], 0);
            int totalNumsBeforeJ = j;
            int badPairs = totalNumsBeforeJ - countOfNumsJ;

            result += badPairs;
            mp.put(nums[j], countOfNumsJ + 1);
        }

        return result;
    }
}
