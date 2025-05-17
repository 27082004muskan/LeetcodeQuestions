class Solution {
    int[] memo;

    public int solve(int[] nums, int idx) {
        int n = nums.length;

        // Base case: already at or beyond last index
        if (idx >= n - 1) return 0;

        // If already computed, return cached result
        if (memo[idx] != -1) return memo[idx];

        int minJumps = Integer.MAX_VALUE;

        // Try all possible jumps from current position
        for (int jump = 1; jump <= nums[idx]; jump++) {
            if (idx + jump < n) {
                int result = solve(nums, idx + jump);
                if (result != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + result);
                }
            }
        }

        // Store and return the result
        memo[idx] = minJumps;
        return minJumps;
    }

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }
}
