class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(list, new ArrayList<>(), nums, used, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> subset, int[] nums, boolean[] used, int index) {
        if (subset.size() == nums.length) {
            list.add(new ArrayList<>(subset));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if(!used[i]) {
                subset.add(nums[i]);
                used[i] = true;
                backtrack(list, subset, nums, used, index);
                used[i] = false;
                subset.remove(subset.size() - 1);
            }
        }
    }
}
