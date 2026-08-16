class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0, high = 0, result = 0, max = 0;
        char[] count = new char[26];
        while (high < s.length()) {
            count[s.charAt(high) - 'A']++;
            max = Math.max(max, count[s.charAt(high) - 'A']);
            while (high - low + 1 - max > k) {
                count[s.charAt(low) - 'A']--;
                low++;
            }
            result = Math.max(result, high - low + 1);
            high++;
        }
        return result;
    }
}
