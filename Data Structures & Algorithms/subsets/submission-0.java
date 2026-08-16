class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        dfs(list, new ArrayList(), nums, 0);
        return list;
    }

    public void dfs (List<List<Integer>> list, List<Integer> curr, int[] nums, int i) {
        list.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            dfs(list,curr, nums, j+1);
            curr.remove(curr.size()-1);
        }

    }
}
