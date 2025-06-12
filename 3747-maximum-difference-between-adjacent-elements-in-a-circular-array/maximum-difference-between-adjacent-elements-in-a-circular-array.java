class Solution {
    public int maxAdjacentDistance(int[] nums) {
       
        int n = nums.length;
         int maxi = Math.abs(nums[n-1]-nums[0]);
        
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(nums[i + 1] - nums[i]);
            maxi = Math.max(maxi, diff);
        }
        
        return maxi;
    }
}
