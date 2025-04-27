class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] minCoin = new int[amount+1];

        for(int i =1;i<=amount;i++){
            minCoin[i]=Integer.MAX_VALUE ;

            for(int coin:coins){
                if(coin<=i && (minCoin[i-coin]!= Integer.MAX_VALUE)){
                    minCoin[i]=Math.min(minCoin[i],1+minCoin[i-coin]);
                }
            }

        }
        if(minCoin[amount]==Integer.MAX_VALUE)
        return -1;

        return minCoin[amount];
    }
}