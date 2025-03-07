class Solution {


     private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
 List<Integer> primes = new ArrayList<>();
        
        // Find all prime numbers in range [left, right]
        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        
        if (primes.size() < 2) {
            return new int[]{-1, -1}; // If less than 2 primes exist
        }

        // Find the closest prime pair
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[2];

        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                ans[0] = primes.get(i - 1);
                ans[1] = primes.get(i);
            }
        }

        return ans;
    }
}