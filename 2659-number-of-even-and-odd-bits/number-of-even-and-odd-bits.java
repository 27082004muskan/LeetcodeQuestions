class Solution {
    public int[] evenOddBit(int n) {
        int temp[]= new int[2];
   
        int index=0;
    
       while (n > 0) {
            if ((n & 1) == 1) { 
                if (index % 2 == 0) {
                    temp[0]++; // Even index
                } else {
                    temp[1]++; // Odd index
                }
            }
            n >>= 1; 
            index++; 
        }
        return temp;
    }
}