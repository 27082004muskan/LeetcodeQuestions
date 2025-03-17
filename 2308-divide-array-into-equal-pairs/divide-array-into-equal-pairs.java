class Solution {
    public boolean divideArray(int[] nums) {
    //     int n = nums.length;
    //     int count = 0;

    //     for (int i = 0; i < n - 1; i++) {
    //         for (int j = i + 1; j < n; j++) {
    //             if (nums[i] == nums[j]) {
    //                 count++;
    //                 nums[j] = -1; 
    //                 break; 
    //             }
    //         }
    //     }
    //     return count == n / 2;
    // }
  

        // Arrays.sort(nums);
        // for(int i = 0 ; i<nums.length ; i += 2){
        //     if(nums[i] != nums[i+1]){
        //         return false ;
        //     }
         
        // }
        // return true  ;


        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Count the frequency of each element
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Check if all frequencies are even
        for (int count : freq.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;


    }
}
