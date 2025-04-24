

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        int m = s.length();
        int n = p.length();

        for (char ch : p.toCharArray())
            arr[ch - 'a']++;

        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();

        while (j < m) {
            arr[s.charAt(j) - 'a']--;

            if (j - i + 1 == n) {
                if (isZeroArray(arr)) {
                    result.add(i);
                }

                arr[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }

        return result;
    }

    private boolean isZeroArray(int[] arr) {
        for (int val : arr) {
            if (val != 0) return false;
        }
        return true;
    }
}
