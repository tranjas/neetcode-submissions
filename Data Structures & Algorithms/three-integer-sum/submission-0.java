class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1, high = nums.length - 1, temp = nums[i];
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            while (low < high) {
                int total = nums[low] + nums[high] + temp;
                if (total == 0) {
                    result.add(Arrays.asList(temp, nums[low], nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }
                    while (high > low && nums[high] == nums[high - 1]) {
                        high--;
                    }
                    low++;
                    high--;
                } else if (total < 0) {
                    low ++;
                } else if (total > 0) {
                    high--;
                }
            }
        }
        return result;
    }
}
