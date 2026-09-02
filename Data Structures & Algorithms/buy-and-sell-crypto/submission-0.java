class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int winmax = 0;

        while(sell<prices.length){
            if(prices[buy]<prices[sell]){
                int profit = prices[sell]-prices[buy];
                winmax= Math.max(profit, winmax);
            }
            else{
                buy=sell;
            }
            sell++;
        }
        return winmax;
    }
}
