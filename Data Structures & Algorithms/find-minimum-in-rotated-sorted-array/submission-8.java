class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                // The minimum is in the right half
                l = m + 1;
            } else {
                // The minimum is in the left half (including m)
                r = m;
            }
        }
        return nums[l]; // The minimum element
    }
}