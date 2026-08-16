class Solution {
    private int[] parent, rank;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // Tree must have exactly n-1 edges
        
        parent = new int[n];
        rank = new int[n];

        // Initialize Union-Find
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        boolean hasCycle = false;
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) hasCycle = true;
        }
        if (hasCycle) return false; // Graph should not have a cycle

        // Ensure all nodes are connected
        int root = find(0);
        for (int i = 1; i < n; i++) {
            if (find(i) != root) return false;
        }

        return true;
    }

    // Path Compression
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // Union by Rank
    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 == p2) return true; // Cycle detected

        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;  // Attach p2's root to p1
            rank[p1]++;
        } else {
            parent[p1] = p2;  // Attach p1's root to p2
            rank[p2]++;
        }
        return false;
    }
}
