class Solution {
    private String[] phone = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) return result;
        backtrack(0, digits, "", result);
        return result;
    }

    public void backtrack (int i, String digits, String curr, List<String> result) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }
        String temp = phone[digits.charAt(i) - '0'];
        for (char c : temp.toCharArray()) {
            backtrack(i + 1, digits, curr + c, result);
        }
    }
}
