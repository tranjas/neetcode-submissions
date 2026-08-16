class Solution {
    private int[][] memo;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0]; 
        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1; 
            memo[i][1] = -1; 
        }
        return Math.max(dfs(nums, 0, 1), dfs(nums, 1, 0));
    }

    private int dfs(int[] nums, int i, int flag) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) {
            return 0;
        }
        if (memo[i][flag] != -1) {
            return memo[i][flag];
        }

        int skip = dfs(nums, i + 1, flag);
        int rob = nums[i] + dfs(nums, i + 2, flag);
        memo[i][flag] = Math.max(skip, rob);
        return memo[i][flag];
    }
}