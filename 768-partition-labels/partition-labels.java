

// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         int[] freq = new int[26];
//         int a = 'a';

//         for (char c : s.toCharArray()) {
//             freq[c - a]++;
//         }

//         List<Integer> output = new ArrayList<>();
//         int prevEnd = 0;

//         for (int i = 0; i < s.length(); i++) {
//             freq[s.charAt(i) - a]--;

//             if (isValid(prevEnd, i, s, freq)) {
//                 output.add(i - prevEnd + 1);
//                 prevEnd = i + 1;
//             }
//         }

//         return output;
//     }

//     private boolean isValid(int start, int end, String s, int[] freq) {
//         for (int i = start; i <= end; i++) {
//             if (freq[s.charAt(i) - 'a'] != 0) return false;
//         }
//         return true;
//     }
// }


class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int startIndex = i;
            int endIndex = s.lastIndexOf(s.charAt(startIndex));

            for (int j = startIndex + 1; j < endIndex; j++) {
                int lastIndexOfNextChar = s.lastIndexOf(s.charAt(j));
                if (lastIndexOfNextChar > endIndex) {
                    endIndex = lastIndexOfNextChar;
                }
            }

            partitions.add(endIndex - startIndex + 1);
            i = endIndex + 1; // This is okay because we're not in a for loop anymore
        }

        return partitions;
    }
}
