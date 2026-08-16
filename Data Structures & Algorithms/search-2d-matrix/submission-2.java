class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int top = 0, bottom = matrix.length - 1;
        while (top <= bottom) {
            int mid = top + (bottom - top)/2;
            int left = matrix[mid][0];
            int right = matrix[mid][matrix[0].length-1];
            if (left <= target && target <= right) {
                int l = 0, r = matrix[mid].length - 1;
                while (l <= r) {
                    int temp = l + (r - l)/2;
                    if (matrix[mid][temp] == target) return true;
                    else if (matrix[mid][temp] < target) l = temp+1;
                    else r = temp - 1;
                }
                return false;
            } else if (target > right) top = mid + 1;
            else bottom = mid - 1;
        }
        return false;
    }
}
