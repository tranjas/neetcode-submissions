class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max (max, pile);
        }
        int l = 1, r = max, result = max;
        while (l <= r) {
            int m = l + (r - l)/2;
            int time = 0;
            for (int pile : piles) {
                time += Math.ceil((double) pile/m);
            }
            if (time <= h) {
                result = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return result;
    }
}
