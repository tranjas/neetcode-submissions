class Solution {
    public boolean canJump(int[] nums) {
        return dfs(nums, 0);
    }
    
    public boolean dfs(int[] nums, int index) {
        if (index >= nums.length - 1) return true; // Reached or passed the last index

        // Check all possible jumps from current index
        for (int i = 1; i <= nums[index]; i++) {
            if (dfs(nums, index + i)) {
                return true;
            }
        }

        return false; // No valid jump found
    }
}
