class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        backtrack(result, subset, nums, target, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            if(target - nums[i] >= 0) {
                subset.add(nums[i]);
                backtrack(result, subset, nums, target - nums[i], i);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
