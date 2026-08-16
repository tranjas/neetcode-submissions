class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int low = 0, high = 0, max = 0;;
        Set<Character> set = new HashSet<>();
        char[] c = s.toCharArray();
        while (high < s.length()) {
            while (set.contains(c[high])) {
                set.remove(c[low]);
                low++;
            }
            set.add(c[high]);
            max = Math.max (max, high - low + 1);
            high++;
        }
        return max;
    }
}
