class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0, result = 0, max = 0;
        char[] count = new char[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
            max = Math.max(max, count[s.charAt(i) - 'A']);
            if (i - low + 1 - max > k) {
                count[s.charAt(low) - 'A']--;
                low++;
            }
            result = Math.max(result, i - low + 1);
        }
        return result;
    }
}
