class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> curr, String s, int temp) {
        if (temp == s.length()) {
            result.add(new ArrayList<>(curr));
        }
        for (int i = temp; i < s.length(); i++) {
            String sub = s.substring(temp, i + 1);
            if (isPalindrome(sub)) {
                curr.add(sub);
                backtrack(result, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
    }
}
