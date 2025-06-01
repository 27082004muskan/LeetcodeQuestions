class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        String[] ans = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            ans[i] = "";
        }

        int i = 0;
        while (i < s.length()) {
            // Go down
            for (int index = 0; index < numRows && i < s.length(); index++) {
                ans[index] += s.charAt(i++);
            }
            // Go up diagonally
            for (int index = numRows - 2; index > 0 && i < s.length(); index--) {
                ans[index] += s.charAt(i++);
            }
        }

        String res = "";
        for (String str : ans) {
            res += str;
        }
        return res;
    }
}
