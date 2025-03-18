class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int maxm = 1; // At least one element is always a nice subarray

        for (int i = 0; i < n; i++) {
            int bitMask = 0, count = 0;

            for (int j = i; j < n; j++) {
                if ((bitMask & nums[j]) == 0) {  // Check if nums[j] can be added
                    bitMask |= nums[j]; // Add nums[j] to the bitMask
                    count++;
                    maxm = Math.max(maxm, count);
                } else {
                    break; // If conflict, stop and move to the next i
                }
            }
        }
        return maxm;
    }
}
