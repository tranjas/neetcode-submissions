class Solution {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            }
            max = Math.max(max, prices[i] - low);
        }
        return max;
    }
}
