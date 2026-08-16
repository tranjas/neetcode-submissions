class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo  = new int[nums.length];
        Arrays.fill(memo, -1);
        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }

    public int dfs(int[] nums, int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        return memo[i] = Math.max(dfs(nums, i + 1), dfs(nums, i + 2) + nums[i]);
    }
}
