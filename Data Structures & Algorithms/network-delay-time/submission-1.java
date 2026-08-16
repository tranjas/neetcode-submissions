class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<int[]>> edges = new HashMap();
        Queue<int[]> bfs = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet();
        for (int[] time : times) {
            edges.putIfAbsent(time[0], new ArrayList<>());
            edges.get(time[0]).add(new int[]{time[1], time[2]});
        }
        bfs.offer(new int[]{0, k});
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            int node = curr[1], weight = curr[0];
            if (visited.contains(node)) continue;
            result = weight;
            visited.add(node);
            if (edges.containsKey(node)) {
                for (int[] edge : edges.get(node)) {
                    if (!visited.contains(edge[0])) {
                        bfs.offer(new int[]{weight + edge[1], edge[0]});
                    }
                }
            }
        }
        return visited.size() == n ? result : -1;
    }
}
