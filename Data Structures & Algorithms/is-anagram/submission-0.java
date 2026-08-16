class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Convert strings to char arrays
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        // Sort the char arrays
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        // Compare the sorted char arrays
        return Arrays.equals(sArray, tArray);
    }
}
