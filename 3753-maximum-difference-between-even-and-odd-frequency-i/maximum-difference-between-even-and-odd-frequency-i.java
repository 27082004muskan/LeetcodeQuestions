// class Solution {
//     public int maxDifference(String s) {
//          HashMap<Character , Integer> map = new HashMap<>();
//        int diff =0;
//        int max_diff = Integer.MIN_VALUE ;
        

//        for(char ch:s.toCharArray()){
//         // count frequency of ch(i)
//         map.put(ch , map.getOrDefault(ch , 0)+1);
//          }
//      if(map.entrySet() %2 !=) freq1 = map.value ; // it's not map.value it is map.entrySet
//      if(map.entrySet() %2 ==0) freq2= map.value;

//     diff= freq1-freq2;   
//     max_diff = Math.max(max_diff, diff);
//     return max_diff;
//     }
// }

public class Solution{
    public int maxDifference(String s){
        // Step 1: Count Frequencies of each character
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Step 2: Separate odd and even frequencies
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int frequency : map.values()) {
            if (frequency % 2 != 0) { // If frequency is odd
                odd.add(frequency);
            } else { // If frequency is even
                even.add(frequency);
            }
        }

        int maxOddFreq = Collections.max(odd);
        int minEvenFreq = Collections.min(even);

        // Step 4: Calculate the maximum difference
        return maxOddFreq - minEvenFreq;
    }
}


// public class Solution {
//     public int maxDifference(String s) {
//         int[] freq = new int[26];
//         for (char c : s.toCharArray()) {
//             freq[c - 'a']++;
//         }

//         int odd = 0;
//         int even = s.length();
//         for (int n : freq) {
//             if ((n & 1) == 1) {
//                 odd = Math.max(odd, n);
//             } else if (n != 0) {
//                 even = Math.min(even, n);
//             }
//         }

//         return odd - even;
//     }
// }