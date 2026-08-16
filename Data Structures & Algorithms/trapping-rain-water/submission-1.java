class Solution {
    public int trap(int[] height) {
        int max = 0, low = 0, high = height.length - 1, maxLeft = 0, maxRight = 0;
        while (low < high) {
            if (height[high] > height[low]) {
                if (height[low] <= maxLeft) {
                    max += maxLeft - height[low];
                    low++;
                } else {
                    maxLeft = height[low];
                    low++;
                }
            } else {
                if (height[high] <= maxRight) {
                    max += maxRight - height[high];
                    high--;
                } else {
                    maxRight = height[high];
                    high--;
                }
            }
        }
        return max;
    }
}
