class Solution {
    public int minTimeToType(String word) {
        char prev = 'a'; // 'a' is a character, so use char instead of int
        int res = 0;     // Start from 0; you'll add the time for each step

        for (char c : word.toCharArray()) { // Fix typo: toCharArray()
            int diff = Math.abs(c - prev);
            res += Math.min(diff, 26 - diff); // Add the min rotation time
            prev = c; // Update prev
        }

        return res + word.length(); // Each character also takes 1 sec to type
    }
}
