class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, max = 0, maxLeft = 0, maxRight = 0;
        while (left <= right) {
            if (maxRight > maxLeft) {
                if (height[left] < maxLeft) {
                    max += maxLeft - height[left];
                } else {
                    maxLeft= height[left];
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    max += maxRight - height[right];
                } else {
                    maxRight = height[right];
                }
                right--;
            }
        }
        return max;
    }
}
