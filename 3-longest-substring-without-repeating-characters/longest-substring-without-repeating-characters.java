// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//          int i =0 , j =0;
//          int maxLen= Integer.MIN_VALUE;
//          HashSet<Character> set = new HashSet<>();
//          int l =0;
//          while(j<n){
//            char ch =  s.charAt(j);
//              if(set.contains(ch)){
//                 while(i<j && set.contains(ch)){
//                     set.remove(s.charAt(i));
//                     i++;
//                 }
              
//              }
//                set.add(ch);
//                 maxLen=Math.max(maxLen , j-i+1);
//                 j++;
//          }
//          return maxLen==Integer.MIN_VALUE ? 0 : maxLen;
//     }
// }

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
         int i =0 , j =0;
         int maxLen= Integer.MIN_VALUE;
         HashMap<Character , Integer> map = new HashMap<>();
         int l =0;

         while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch)>=i){
              i=map.get(ch)+1; }
              
              map.put(ch , j);
            
            maxLen=Math.max(maxLen , j-i+1);
            j++;
         }
         return maxLen==Integer.MIN_VALUE ? 0 : maxLen;
    }
}