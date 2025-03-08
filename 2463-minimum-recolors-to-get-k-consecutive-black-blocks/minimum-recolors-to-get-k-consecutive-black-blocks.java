// class Solution {
//     public int minimumRecolors(String blocks, int k) {
//         char[] arr = blocks.toCharArray();
//         int n = arr.length;
//         int count =0;
//         int tmin = Integer.MAX_VALUE;
//         for(int i =0;i<n;i++){
//             for(int j =1;j<=k;j++){
//                 if(arr[j]=='W'){
//                     count++;
//                 }
                
        
//                 tmin=Math.min(count , tmin);
//             }
//         }
//         return tmin;
//     }
// }

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int count = 0;
        int tmin = Integer.MAX_VALUE;

        // Step 1: Count 'W' in the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
        }
        
        tmin = count; // Initialize minimum recolors with the first window count

        // Step 2: Slide the window across the string
        for (int i = k; i < n; i++) {
            // Remove the leftmost character from the previous window
            if (blocks.charAt(i - k) == 'W') {
                count--;
            }
            // Add the new character into the window
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            // Update the minimum recolor count
            tmin = Math.min(tmin, count);
        }

        return tmin;
    }
}
