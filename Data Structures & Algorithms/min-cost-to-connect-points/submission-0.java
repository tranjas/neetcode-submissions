class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if (n == 0) return 0;
        int result = 0; 
        Set<Integer> visited = new HashSet<>(); 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        minHeap.offer(new int[]{0, 0}); // [weight, node]

        // Prim's Algorithm
        while (!minHeap.isEmpty() && visited.size() < n) {
            int[] curr = minHeap.poll();
            int weight = curr[0], node = curr[1];

            if (visited.contains(node)) continue;

            visited.add(node); 
            result += weight; 
            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    int distance = Math.abs(points[node][0] - points[i][0]) +
                                   Math.abs(points[node][1] - points[i][1]);
                    minHeap.offer(new int[]{distance, i});
                }
            }
        }

        return result;
    }
}