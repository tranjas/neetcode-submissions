class Solution {
    public int minCostConnectPoints(int[][] points) {
        int result = 0;
        Set<Integer> set = new HashSet();
        Queue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.offer(new int[]{0, 0});
        while (!heap.isEmpty() && set.size() < points.length) {
            int[] curr = heap.poll();
            int weight = curr[0], point = curr[1];
            if (set.contains(point)) continue;
            result += weight;
            set.add(point);
            for (int i = 0; i < points.length; i++) {
                if (!set.contains(i)) {
                    int distance = Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1]);
                    heap.offer(new int[]{distance, i});
                }
            }
        }
        return result;
    }
}
