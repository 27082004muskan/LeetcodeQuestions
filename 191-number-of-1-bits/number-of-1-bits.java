class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Check if LSB is 1
            n = n >> 1; // Unsigned right shift (important for negative numbers)
        }
        return count;
    }
}

