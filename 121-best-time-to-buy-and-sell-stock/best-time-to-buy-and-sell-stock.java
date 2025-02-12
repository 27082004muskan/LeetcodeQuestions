// class Solution {
//     public int maxProfit(int[] prices) {
//              if (prices == null || prices.length < 2) {
//             return 0; 
//              }
//         int max=0;
//         int count=0;
//         for(int i=0;i<prices.length-1;i++){
//             for(int j=i+1;j<prices.length;j++){
//                 if(prices[j]>prices[i]){
//              count=prices[j]-prices[i];
//              max=Math.max(max, count);
//                 }
                
//                 }       
//             }
//           return max;
//         }
       
//     }

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0; 

        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]); 
            maxProfit = Math.max(maxProfit, prices[i] - minPrice); 
        }

        return maxProfit;
    }
}
