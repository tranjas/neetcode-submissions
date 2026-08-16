class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = nums[0], temp = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (temp < 0) temp = 0;
            temp += nums[i];
            result = Math.max(result, temp);
        }
        return result;
    }
}
