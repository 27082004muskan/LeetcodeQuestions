class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n * n + 1]; // Array to store frequency of numbers
        int missing = -1, repeated = -1;

        // Count occurrences of each number in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[grid[i][j]]++;
            }
        }

        // Find missing and repeated values
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                missing = i;
            }
            if (arr[i] == 2) {
                repeated = i;
            }
        }

        return new int[]{repeated, missing}; // Return as an array
    }
}
