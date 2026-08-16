class Solution {
    public boolean isPalindrome(String s) {
        // Use StringBuilder for efficient string concatenation
        StringBuilder temp = new StringBuilder();
        
        // Filter out non-alphanumeric characters and convert to lowercase
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                temp.append(Character.toLowerCase(c));
            }
        }
        
        // Convert StringBuilder to String
        String filteredString = temp.toString();
        
        // Two-pointer approach to check for palindrome
        int low = 0, high = filteredString.length() - 1;
        while (low < high) {
            if (filteredString.charAt(low) != filteredString.charAt(high)) {
                return false; // Characters don't match, not a palindrome
            }
            low++;
            high--;
        }
        
        return true; // All characters matched, it's a palindrome
    }
}
