package BestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int lst = Integer.MAX_VALUE;
        int op = 0;
        int pist = 0;

        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lst){
                lst = prices[i];
            }
            pist = prices[i] - lst;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
}