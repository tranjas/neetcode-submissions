class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, 0, 0, n, "");
        return list;
    }

    public void backtrack(List<String> list, int open, int close, int max, String current) {
        if (current.length() == max * 2) {
            list.add(current);
            return;
        }
        if (open < max) {
            backtrack(list, open + 1, close, max, current + "(");

        }
        if (close < open) {
            backtrack(list, open, close + 1, max, current + ")");
        }
    }
}
