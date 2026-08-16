class Solution {
    private int[][] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; // Edge case: only one house
        memo = new int[nums.length][2]; // Initialize memoization array
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1; // Mark as uncomputed
            memo[i][1] = -1; // Mark as uncomputed
        }

        // Two cases:
        // 1. Rob the first house (flag = 1), skip the last house
        // 2. Skip the first house (flag = 0), consider the last house
        return Math.max(dfs(nums, 0, 1), dfs(nums, 1, 0));
    }

    private int dfs(int[] nums, int i, int flag) {
        // Base case: out of bounds or last house cannot be robbed if first house was robbed
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) {
            return 0;
        }

        // Return memoized result if already computed
        if (memo[i][flag] != -1) {
            return memo[i][flag];
        }

        // Two choices:
        // 1. Skip the current house and move to the next house
        // 2. Rob the current house and move to the house after the next
        int skip = dfs(nums, i + 1, flag);
        int rob = nums[i] + dfs(nums, i + 2, flag);

        // Store the result in the memoization array
        memo[i][flag] = Math.max(skip, rob);
        return memo[i][flag];
    }
}