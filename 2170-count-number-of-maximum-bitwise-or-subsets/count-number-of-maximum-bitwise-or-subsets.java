class Solution {
    // O(2^n)
    private int countSubsets(int idx, int currOr, int[] nums, int maxOr, int[][] t) {
        if (idx == nums.length) {
            if (currOr == maxOr)
                return t[idx][currOr] = 1; // Found one subset
            return t[idx][currOr] = 0;
        }

        if (t[idx][currOr] != -1) {
            return t[idx][currOr];
        }

        // Take nums[idx]
        int takeCount = countSubsets(idx + 1, currOr | nums[idx], nums, maxOr, t);

        // Not taken nums[idx]
        int notTakeCount = countSubsets(idx + 1, currOr, nums, maxOr, t);

        return t[idx][currOr] = takeCount + notTakeCount;
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        int n = nums.length;

        int[][] t = new int[n + 1][maxOr + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxOr; j++) {
                t[i][j] = -1;
            }
        }

        int currOr = 0;
        return countSubsets(0, currOr, nums, maxOr, t);
    }
}