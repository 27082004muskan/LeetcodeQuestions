

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // int n = nums.length;
        // List<Integer> duplicates = new ArrayList<>(); // Using List instead of array
        
        // for (int i = 0; i < n - 1; i++) {  // Loop till n-1
        //     for (int j = i + 1; j < n; j++) { // Start from i+1
        //         if (nums[i] == nums[j]) {
        //             if (!duplicates.contains(nums[i])) { // Avoid adding duplicates twice
        //                 duplicates.add(nums[i]);
        //             }
        //             break; // Break after finding the first duplicate
        //         }
        //     }
        // }
        // return duplicates;
 
int n = nums.length;
List<Integer> arr= new ArrayList<Integer>();
 int j =1;
 Arrays.sort(nums);
 for(int i =0;i<n-1;i++){
    if(nums[i]==nums[j]){
        arr.add(nums[j]);
      
    }
      j++;
 }
 return arr;
      
    }

}
