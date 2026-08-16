class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> subset = new ArrayList();
        Arrays.sort(candidates);
        backtrack(result, subset, candidates, target, 0);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] candidates, int target, int pos) {
        if (target == 0) {
            result.add(new ArrayList<>(subset));
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target - candidates[i] >= 0) {
                subset.add(candidates[i]);
                backtrack(result, subset, candidates, target - candidates[i], i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
