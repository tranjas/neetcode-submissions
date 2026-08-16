class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1001);
        dp[nums.length -1] = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            int end = Math.min(nums.length, nums[i] + i + 1);
            for (int j = i + 1; j < end; j++) {
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
        }
        return dp[0] != 1001;
    }
}
