class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // no of subarrays of a segment size n = n*(n+1)/2;
        // if(8,4) is given i.e. a>b swap the values for correct order
        // sort all the values on the basis of end value
        // max profit interval-> toatl-blocked+profit = valid subarray
        //profit = (max1-max2)*gap
        //blocked +=max1*gap

        int m = conflictingPairs.length;

        //ensure each pair is ordered
            for (int i = 0; i < m; i++) {
            if (conflictingPairs[i][0] > conflictingPairs[i][1]) {
                int temp = conflictingPairs[i][0];
                conflictingPairs[i][0] = conflictingPairs[i][1];
                conflictingPairs[i][1] = temp;
            }
        }


        // Sort by end value using lambda
        Arrays.sort(conflictingPairs, (a, b) -> a[1] - b[1]);

        long blocked = 0, profit = 0, maxProfit = 0;
        long max1 = 0, max2 = 0;

             for (int i = 0; i < m; i++) {
            int start = conflictingPairs[i][0];
            int end = conflictingPairs[i][1];
            int bottom = (i < m - 1 ? conflictingPairs[i + 1][1] : n + 1);
            int gap = bottom - end;

            if (start > max1) {
                max2 = max1;
                max1 = start;
                profit = 0;
            } else if (start > max2) {
                max2 = start;
            }

            profit += (max1 - max2) * 1L * gap;
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            blocked += max1 * 1L * gap;
        }

        long totalSubarrays = n * 1L * (n + 1) / 2;
        return totalSubarrays - blocked + maxProfit;


    }
}