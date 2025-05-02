import java.util.*;

class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        char prev = '.';
        int count = 1;

        // Left to right pass
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                prev = 'R';
                count = 1;
            } else if (dominoes.charAt(i) == 'L') {
                prev = 'L';
            }

            if (prev == 'R' && dominoes.charAt(i) == '.') {
                right[i] = count;
                count++;
            }
        }

        // Right to left pass
        prev = '.';
        count = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                prev = 'L';
                count = 1;
            } else if (dominoes.charAt(i) == 'R') {
                prev = 'R';
            }

            if (prev == 'L' && dominoes.charAt(i) == '.') {
                left[i] = count;
                count++;
            }
        }

        // Build the final result
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (left[i] == 0 && right[i] == 0) {
                finalResult.append(dominoes.charAt(i));
            } else if (left[i] == 0) {
                finalResult.append('R');
            } else if (right[i] == 0) {
                finalResult.append('L');
            } else if (left[i] == right[i]) {
                finalResult.append('.');
            } else if (left[i] > right[i]) {
                finalResult.append('R');
            } else {
                finalResult.append('L');
            }
        }

        return finalResult.toString();
    }
}
