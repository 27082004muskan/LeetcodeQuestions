class Solution {
    public String removeDigit(String number, char digit) {
        char[] arr = number.toCharArray(); // Step 1: Convert to char array

        int indexToRemove = -1; // store the index to remove

        // Step 2: Traverse from left to right to find best place to remove
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == digit) {
                indexToRemove = i;

                // Greedy check: if next digit is bigger, remove here
                if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
                    break;
                }
            }
        }

        // Step 3: Build the new string without the digit at indexToRemove
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i != indexToRemove) {
                sb.append(arr[i]);
            }
        }

        return sb.toString(); // Step 4: Return the new string
    }
}
