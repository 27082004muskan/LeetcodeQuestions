class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) 
            return 1;

        boolean sign = true;
        if ((dividend >= 0 && divisor < 0) || (dividend <= 0 && divisor > 0)) 
            sign = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        
        long quotient = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
          //  quotient += (long) Math.pow(2, cnt);

         quotient += (1L << cnt);
            n -= (d << cnt);
        }

        if (quotient > Integer.MAX_VALUE && sign) 
            return Integer.MAX_VALUE;

        if (quotient > Integer.MAX_VALUE && !sign) 
            return Integer.MIN_VALUE;

        return sign ? (int) quotient : (int) -quotient;
    }
}
