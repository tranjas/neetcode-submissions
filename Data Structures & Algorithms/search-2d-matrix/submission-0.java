class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int bot = matrix.length - 1, col = matrix[0].length - 1, top = 0;

        while (top <= bot) {
            int temp = top + (bot - top)/2;
            if (target <= matrix[temp][col] && target >= matrix[temp][0]) {
                int low = 0, high = col;
                while (low <= high) {
                    int curr = low + (high-low)/2;
                    if (target == matrix[temp][curr]) return true;
                    else if (target < matrix[temp][curr]) {
                        high = curr - 1;
                    } else {
                        low = curr + 1;
                    }
                }
                return false;
            } else if (target > matrix[temp][col]) {
                top = temp + 1;
            } else {
                bot = temp - 1;
            }
        }
        return false;
    }
}
