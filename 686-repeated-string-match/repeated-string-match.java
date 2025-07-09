public class Solution {
    public int repeatedStringMatch(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        
        int n = lenB / lenA;
        int count = n;

        StringBuilder na = new StringBuilder();
        while (count-- > 0) {
            na.append(a);
        }

        if (na.indexOf(b) != -1) return n;

        na.append(a);
        if (na.indexOf(b) != -1) return n + 1;

        na.append(a);
        if (na.indexOf(b) != -1) return n + 2;

        return -1;
    }
}
