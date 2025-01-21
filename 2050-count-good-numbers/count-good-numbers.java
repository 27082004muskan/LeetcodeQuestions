class Solution {
    private long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Number of even and odd positions
        long even = (n + 1) / 2; // Count of even indices
        long odd = n / 2;        // Count of odd indices

        // Compute 5^even % MOD and 4^odd % MOD
        long first = pow(5, even) % MOD;
        long second = pow(4, odd) % MOD;

        // Return the result modulo MOD
        return (int) ((first * second) % MOD);
    }

    private long pow(long x, long n) {
        if (n == 0) return 1; // Base case: x^0 = 1
        long temp = pow(x, n / 2) % MOD; // Recursive call
        temp = (temp * temp) % MOD;     // Square the result
        if (n % 2 == 0) {
            return temp; // If n is even
        } else {
            return (x * temp) % MOD; // If n is odd
        }
    }
}
