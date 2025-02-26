class Solution {
    public int[] twoSum(int[] nums, int target) {
           int[] temp =new int[2];
        // for(int i =0;i<nums.length-1;i++){
        //     for(int j = i+1;j<nums.length;j++){
        //       if(nums[i]+nums[j]==target){
        //      temp[0] = i;
        //             temp[1] = j;
        //             return temp;
        //       }
        //     }
        // }
        // return temp;
      

      // METHOD-2 
    // int n = nums.length;
    // int i = 0, j = n - 1;  // Two pointers

    // while (i < j) {
    //     int sum = nums[i] + nums[j];

    //     if (sum == target) {
    //         temp[0] = i;
    //         temp[1] = j;
    //         return temp; 
    //     } else if (sum < target) {
    //         i++;  // Move left pointer forward to increase sum
    //     } else {
    //         j--;  // Move right pointer backward to decrease sum
    //     }
    // }
    // return new int[] {};  // Return empty array if no solution found

Map<Integer , Integer> map =new HashMap<>();
for(int i =0;i<nums.length;i++){
 int complement = target-nums[i];


  if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
     map.put(nums[i], i);

    }
    return new int[]{-1, -1};
    }
}

