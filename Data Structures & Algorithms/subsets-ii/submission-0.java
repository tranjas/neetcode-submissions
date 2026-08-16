class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    public void backtrack (List<List<Integer>> list, List<Integer> curr, int[] nums, int temp) {
        list.add(new ArrayList<>(curr));
        for (int i = temp; i < nums.length; i++) {
            if(i > temp && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            backtrack(list, curr, nums, i + 1);
            curr.remove(curr.size()-1);
        }
    }
}
