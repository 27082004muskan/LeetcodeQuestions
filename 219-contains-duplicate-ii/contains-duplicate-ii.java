// class Solution {
//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         int n = nums.length;
//         for(int i =0;i<n-1;i++){
//             for(int j =i+1;j<n;j++){
//                if(nums[i] == nums[j] && (Math.abs(i - j) <= k)){
//                 return true ;
//                }
//             }
//         }
//         return false ;
//     }
// }


class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        int i = 0, j = 0;

        while (j < n) {
            // Maintain window of size at most k
            if (j - i > k) {
                st.remove(nums[i]);
                i++;
            }

            // If current element is already in the set, duplicate exists
            if (st.contains(nums[j])) {
                return true;
            }

            // Add current element to set
            st.add(nums[j]);

            j++;
        }

        return false;
    }
}
