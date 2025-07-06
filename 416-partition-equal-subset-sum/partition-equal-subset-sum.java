// class Solution {
//     int[][] t = new int[201][20001];

//     boolean solve(List<Integer> nums, int i, int x) {
//         if (x == 0) {
//             return true;
//         }

//         if (i >= nums.size()) {
//             return false;
//         }

//         if (t[i][x] != -1) {
//             return t[i][x] == 1;
//         }

//         boolean take = false;
//         if (nums.get(i) <= x) {
//             take = solve(nums, i + 1, x - nums.get(i));
//         }

//         boolean not_take = solve(nums, i + 1, x);

//         t[i][x] = (take || not_take) ? 1 : 0;
//         return take || not_take;
//     }

//     public boolean canPartition(int[] numsArr) {
//         List<Integer> nums = new ArrayList<>();
//         for (int num : numsArr) nums.add(num);

//         int n = nums.size();
//         int S = 0;
//         for (int num : nums) {
//             S += num;
//         }

//         if (S % 2 != 0) {
//             return false;
//         }

//         for (int[] row : t) {
//             Arrays.fill(row, -1);
//         }

//         int x = S / 2;

//         return solve(nums, 0, x);
//     }
// }



class Solution {
     public boolean canPartition(int[] numsArr) {
        int total = 0;
        for (int num : numsArr) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = numsArr.length;

        // dp[i] = true if a subset with sum i can be formed
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // empty subset sum = 0 is always possible

        for (int num : numsArr) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
}
}
