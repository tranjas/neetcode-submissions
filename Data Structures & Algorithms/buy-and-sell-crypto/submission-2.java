class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE, result = 0;;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            result = Math.max(result, prices[i] - low);
        }
        
        return result;
    }
}
