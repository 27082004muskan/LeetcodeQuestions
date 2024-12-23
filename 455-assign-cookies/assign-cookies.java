class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int l = 0;
        int r = 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        while (l < m && r < n) {
            if (g[r] <= s[l]) {
                r++;  // Satisfy one child and move to the next
            }
            l++;  // Move to the next cookie
        }
        
        return r;  // Return the number of content children
    }
}
