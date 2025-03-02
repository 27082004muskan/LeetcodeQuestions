class Solution {

     public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int nonZeroIndex = 0;
         for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            } }
             while(nonZeroIndex<nums.length){
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
         for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] != 0) {
                nums[i] *= 2; 
                nums[i + 1] = 0; 
            }
        }

        //  if (temp[n - 1] == 0) {
        //     temp[n - 1] = nums[n - 1];
        // }
         moveZeroes(nums);
        return nums;

    }
}