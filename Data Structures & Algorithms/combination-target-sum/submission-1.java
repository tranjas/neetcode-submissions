class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        backtrack(list, new ArrayList<>(), target, 0, nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> curr, int target, int temp, int[] nums) {
        if (target == 0) {
            list.add(new ArrayList<>(curr));
        }
        for (int i = temp; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                curr.add(nums[i]);
                backtrack(list, curr, target - nums[i], i, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
