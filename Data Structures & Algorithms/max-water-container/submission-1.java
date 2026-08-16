class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length - 1, result = 0;
        while (left < right) {
            if (heights[left] > heights[right]) {
                result = Math.max(result, (right - left) * heights[right]);
                right--;
            } else {
                result = Math.max(result, (right - left) * heights[left]);
                left++;
            }
        } 
        return result;
    }
}
