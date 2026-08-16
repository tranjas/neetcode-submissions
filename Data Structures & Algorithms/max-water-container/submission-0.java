class Solution {
    public int maxArea(int[] heights) {
        int low = 0, high = heights.length-1, max = 0;
        while (low < high) {
            int temp = (high - low) * Math.min(heights[high], heights[low]);
            max = Math.max(max, temp);
            if (heights[low] > heights[high]) {
                high--;
            } else {
                low++;
            }
        }
        return max;
    }
}
