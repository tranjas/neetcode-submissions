class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1000);
        dp[nums.length -1] = 0;
        for (int i = nums.length - 2; i >= 0; i--){
            int end = Math.min(nums.length, nums[i] + i + 1);
            for (int j = i + 1; j < end; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[j]);
            }
        }
        return dp[0];
    }
}
