class Solution {
    public int longestPalindrome(String s) {
        // check occurence - should be mulyiple of 2 
        //if .. set 1 in i and 2nd at n
       // and then i++ , n--

       // last ... store them and count 
       int n = s.length();
       if(n==1) return 1 ;
       int length=0;

    
        HashMap<Character , Integer> hm = new HashMap<>();
        for(char num : s.toCharArray()){
            hm.put(num , hm.getOrDefault( num,0)+1);
        }
      
        boolean hasOdd = false;

        for (int freq : hm.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1; // take even part
                hasOdd = true;
            }
        }

        // If any odd character exists, we can place one in the center
        if (hasOdd) {
            length += 1;
        }
        
        return length ;
        }
}