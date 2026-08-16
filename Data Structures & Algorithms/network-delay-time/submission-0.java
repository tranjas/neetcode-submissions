class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        Map<Integer, List<int[]>> edges = new HashMap();
        for (int[] time : times) {
            edges.computeIfAbsent(time[0], key -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        Queue<int[]> bfs = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        bfs.add(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();
            int w = curr[0], n1 = curr[1];
            if (visited.contains(n1)) {
                continue;
            }
            visited.add(n1);
            result = w;
            if (edges.containsKey(n1)) {
                for (int[] next : edges.get(n1)) {
                    if (!visited.contains(next[0])) {
                        bfs.add(new int[]{w + next[1], next[0]});
                    }
                }
            }
        }
        return visited.size() == n ? result : -1;
    }
}
