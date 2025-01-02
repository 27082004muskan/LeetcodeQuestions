import java.util.Arrays;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;

        // Array to store {soldier count, row index}
        int[][] soldierCount = new int[n][2];

        // Calculate the number of soldiers in each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    count++;
                } else {
                    break; // Stop counting once we hit a 0
                }
            }
            soldierCount[i][0] = count;
            soldierCount[i][1] = i; // Store the row index
        }

        // Sort the array by soldier count, then by row index
        Arrays.sort(soldierCount, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Extract the indices of the k weakest rows
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = soldierCount[i][1];
        }

        return result;
    }
}
