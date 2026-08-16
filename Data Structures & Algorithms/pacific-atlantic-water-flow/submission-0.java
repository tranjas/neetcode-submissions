class Solution {
    int[][] directions = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);
            dfs(heights, i, cols - 1, atlantic, heights[i][cols - 1]);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);
            dfs(heights, rows - 1, j, atlantic, heights[rows - 1][j]);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }

        return result;
    }
    public void dfs(int[][] heights, int i , int j, boolean[][] ocean, int current) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < current || ocean[i][j] == true) return;
        ocean[i][j] = true;
        for (int[] dir : directions) {
            dfs(heights, i + dir[0], j + dir[1], ocean, heights[i][j]);
        }
    }

}
