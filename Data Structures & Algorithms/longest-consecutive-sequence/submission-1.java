class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            int temp = 1;
            while (set.contains(num - 1)) {
                num--;
                temp++;
            }
            result = Math.max(result, temp);
        }
        return result;
    }
}
