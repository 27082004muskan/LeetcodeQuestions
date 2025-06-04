// class Solution {
//     public String answerString(String word, int numFriends) {
//         int n = word.length();
//         char[] ch = word.toCharArray();

//         int div = n / numFriends;
//         int rem = n % numFriends;

//         StringBuilder sb = new StringBuilder();
//         int index = 0;

//         for (int i = 0; i < numFriends; i++) {
//             int finalA = div + (i < rem ? 1 : 0); 
//             for (int j = 0; j < finalA; j++) {
//                 sb.append(ch[index++]);
//             }
//         }

//         return sb.toString();
//     }
// }

class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if (numFriends == 1) {
            return word;
        }

        int longestPossible = n - (numFriends - 1);
        String result = "";

        for (int i = 0; i < n; i++) {
            int canTakeLength = Math.min(longestPossible, n - i);
            String sub = word.substring(i, i + canTakeLength);
            if (sub.compareTo(result) > 0) {
                result = sub;
            }
        }

        return result;
    }
}
