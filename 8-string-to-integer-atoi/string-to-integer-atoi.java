class Solution {
    public int myAtoi(String s) {
        int sign = 1; // Sign of the number (+1 or -1)
        int result = 0; // Final result
        int i = 0; // Pointer for iteration
        int n = s.length(); // Length of the string

        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // Step 2: Check for a sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // Step 3: Process digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0'; // Convert character to integer
            
            // Step 3.1: Handle overflow/underflow
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Step 3.2: Update result
            result = result * 10 + digit;
            i++;
        }

        // Step 4: Return the final result with the correct sign
        return result * sign;
    }
}
