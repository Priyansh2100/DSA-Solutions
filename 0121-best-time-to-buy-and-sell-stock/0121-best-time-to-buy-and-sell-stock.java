class Solution {
    public int maxProfit(int[] prices) {

        // store the best (minimum) price to buy so far
        int bestbuy = prices[0];  

        // store maximum profit so far
        int maxprofit = 0;  

        // iterate through prices from day 1
        for (int i = 1; i < prices.length; i++) {

            // if current price is greater than bestbuy, calculate profit
            if (prices[i] > bestbuy) {
                maxprofit = Math.max(maxprofit, (prices[i] - bestbuy));
            }

            // update bestbuy if we find a lower price
            bestbuy = Math.min(bestbuy, prices[i]);
        }

        // return maximum profit after checking all days
        return maxprofit;
    }
}
