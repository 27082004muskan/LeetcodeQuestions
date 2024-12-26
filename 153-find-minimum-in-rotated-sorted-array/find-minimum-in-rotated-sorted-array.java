class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;  // Handle edge case (empty array)
        }
        
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Optimization: If the array is already sorted
            if (nums[low] < nums[high]) {
                ans = Math.min(ans, nums[low]);
                break;
            }

            // Left part is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                // Right part is sorted
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }

        return ans;
    }
}
