class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1]*a[1] + a[0]*a[0])-(b[1]*b[1] + b[0]*b[0]));
        int[][] result = new int[k][2];
        for (int[] point : points) {
            queue.add(point);
        }
        for (int i = 0; i < k; i++) {
            int[] temp = queue.poll();
            result[i] = temp;
        }
        return result;
    }
}
