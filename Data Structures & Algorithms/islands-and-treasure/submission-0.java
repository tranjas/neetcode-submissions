class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    bfs.add(new int[]{i,j});
                }
            }
        }
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        while (!bfs.isEmpty()) {
            int[] temp = bfs.poll();
            int value = grid[temp[0]][temp[1]];
            for (int[] curr : directions) {
                int x = temp[0] + curr[0];
                int y = temp[1] + curr[1];
                if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && grid[x][y] == Integer.MAX_VALUE) {
                    grid[x][y] = value + 1;
                    bfs.add(new int[]{x,y});
                }
            }
        }
    }
}
