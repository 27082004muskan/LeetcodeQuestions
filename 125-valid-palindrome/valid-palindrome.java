class Solution {
    // Clean string: keep letters and digits, convert to lowercase
    private String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {   // keep letters AND digits
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public boolean isPalindrome(String s) {
        String cleaned = cleanString(s);

        int left = 0, right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
