class Solution {
    public int orangesRotting(int[][] grid) {
        int fruit = 0;
        int result = 0;
        Queue<int[]> bfs = new LinkedList();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) fruit++;
                else if(grid[i][j] == 2) bfs.offer(new int[]{i, j});
            }
        }
        int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!bfs.isEmpty() && fruit> 0) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = bfs.poll();
                for (int[] dir : directions) {
                    int x = dir[0] + rotten[0];
                    int y = dir[1] + rotten[1];
                    if (x >= 0 && x <= grid.length - 1 && y >= 0 && y <= grid[0].length - 1 && grid[x][y] == 1) {
                        fruit--;
                        grid[x][y] = 2;
                        bfs.offer(new int[]{x, y});
                    }
                }
            }
            result++;
            
        }
        return fruit == 0 ? result : -1;
    }
}
