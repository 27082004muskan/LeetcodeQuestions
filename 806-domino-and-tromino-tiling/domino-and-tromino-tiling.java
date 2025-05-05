class Solution {
    public int numTilings(int N) {
        int md = 1000000007; // 1e9 + 7
        long[] v = new long[1001];

        v[1] = 1;
        v[2] = 2;
        v[3] = 5;

        if (N <= 3) {
            return (int) v[N];
        }

        for (int i = 4; i <= N; ++i) {
            v[i] = 2 * v[i - 1] + v[i - 3];
            v[i] %= md;
        }

        return (int) v[N];
    }
}
