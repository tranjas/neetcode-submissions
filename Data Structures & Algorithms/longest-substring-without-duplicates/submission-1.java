class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, low = 0, high = 0;
        Set<Character> set = new HashSet<>();
        while (high < s.length()) {
            if (!set.contains(s.charAt(high))) {
                set.add(s.charAt(high));
                max = Math.max(max, set.size());
                high++;
            } else {
                while (set.contains(s.charAt(high))) {
                    set.remove(s.charAt(low));
                    low++;
                }
            }
        }
        return max;
    }
}
