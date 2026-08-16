class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int result = max, low = 1, high = max;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int temp = 0;
            for (int pile : piles) {
                temp += Math.ceil((double)  pile / mid);
            }
            if (temp <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
}
