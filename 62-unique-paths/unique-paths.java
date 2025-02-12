class Solution {
    private int[][] t;

    private int solve(int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) 
            return 0;

        if (i == m - 1 && j == n - 1) 
            return 1;

        if (t[i][j] != -1) 
            return t[i][j];

        int right = solve(i, j + 1, m, n);
        int down = solve(i + 1, j, m, n);

        return t[i][j] = right + down;
    }

    public int uniquePaths(int m, int n) {
        t = new int[m][n];
        for (int[] row : t)
            java.util.Arrays.fill(row, -1);

        return solve(0, 0, m, n);
    }
}
