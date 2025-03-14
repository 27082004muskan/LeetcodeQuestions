class Solution {
    public boolean canDistr(int[] candies, int mid, long k) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
            if (count >= k) return true;
        }
        return false; // Clearer termination condition
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        int maxCandies = 0;
        long totalCandies = 0;  // Changed to long for safety

        for (int candy : candies) {
            totalCandies += candy;
            maxCandies = Math.max(maxCandies, candy);
        }

        if (totalCandies < k) return 0;

        int l = 1;
        int r = maxCandies;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canDistr(candies, mid, k)) {
                result = mid;
                l = mid + 1; // Try for a higher possible value
            } else {
                r = mid - 1;
            }
        }

        return result;
    }
}
