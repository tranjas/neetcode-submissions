class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }

        int low = 1, result = max;
        
        while (low <= max) {
            int mid = low + (max - low) / 2;
            int hoursSpent = 0;
            
            for (int pile : piles) {
                hoursSpent += (pile + mid - 1) / mid; 
            }
            if (hoursSpent <= h) {
                result = mid;
                max = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}
