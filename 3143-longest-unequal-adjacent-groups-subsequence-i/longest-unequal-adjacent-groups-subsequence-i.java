import java.util.*;

class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        if (n == 0) return result;

        // Always include the first word
        result.add(words[0]);
        int prevGroup = groups[0];

        for (int i = 1; i < n; i++) {
            if (groups[i] != prevGroup) {
                result.add(words[i]);
                prevGroup = groups[i]; // update last used group
            }
        }

        return result;
    }
}
