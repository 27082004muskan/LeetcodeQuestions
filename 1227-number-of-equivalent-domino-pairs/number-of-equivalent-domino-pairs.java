class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] hm = new int[100];
        int n = dominoes.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            int t = dominoes[i][0], b = dominoes[i][1];
            int key = 0;

            if (t < b) {
                key = t * 10 + b;
            } else {
                key = b * 10 + t;
            }

            res += hm[key];
            hm[key]++;
        }

        return res;
    }
}
