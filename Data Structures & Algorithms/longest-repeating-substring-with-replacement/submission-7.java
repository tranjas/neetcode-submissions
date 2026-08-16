class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (char c : set) {
            int left = 0, right = 0, count = 0;
            while (right < s.length()) {
                if (s.charAt(right) == c) {
                    count++;
                }
                while ((right - left + 1 - count) > k) {
                    if (s.charAt(left) == c) {
                        count--;
                    }
                    left++;
                }
                result = Math.max(result, right - left + 1);
                right++;
            }
        }
        return result;
    }
}
