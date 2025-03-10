class Solution {
    public boolean fun(String s, int k) {
        boolean a = false, e = false, i = false, o = false, u = false;
        int con = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') a = true;
            else if (ch == 'e') e = true;
            else if (ch == 'i') i = true;
            else if (ch == 'o') o = true;
            else if (ch == 'u') u = true;
            else con++;
        }
        return a && e && i && o && u && (con == k);
    }

    public int countOfSubstrings(String word, int k) {
        int count = 0;
        int n = word.length();

        for (int i = 0; i < n; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = i; j < n; j++) {
                s.append(word.charAt(j));
                if (fun(s.toString(), k)) count++;
            }
        }
        return count;
    }
}
