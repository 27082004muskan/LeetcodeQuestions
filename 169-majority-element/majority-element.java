class Solution {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        // int n=nums.length;
        // return nums[n/2];

       int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 1; // Start with count = 1 for the current element
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
            // Check if the current element is the majority element
            if (count > n / 2) {
                return nums[i];
            }
        }

        // If no majority element exists, though it's guaranteed by problem constraints
        return -1;

    }
}