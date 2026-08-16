class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && backtrack(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = backtrack(board, word, index + 1, i + 1, j) ||
                        backtrack(board, word, index + 1, i - 1, j) ||
                        backtrack(board, word, index + 1, i, j + 1) ||
                        backtrack(board, word, index + 1, i, j - 1);
        board[i][j] = temp;
        return found;
    }
}
