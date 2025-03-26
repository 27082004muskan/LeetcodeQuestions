import java.util.Arrays;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] arr = new int[size];

        // Flatten the 2D grid into a 1D array
        int index = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[index++] = grid[i][j];
            }
        }

        // Sort the array
        Arrays.sort(arr);

        // Find the median
        int target = arr[size / 2];

        int result = 0;
        for (int num : arr) {
            if (num % x != target % x) {
                return -1;
            }
            result += Math.abs(target - num) / x;
        }

        return result;
    }
}
