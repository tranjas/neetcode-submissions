class Solution {
    int[] parent, rank;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            if (detectCycle(edge[0],edge[1])) return false;
        }
        int p = parent[0];
        for (int i = 1; i < n; i++) {
            if(p != parent[i]) return false;
        }
        return true;
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public boolean detectCycle(int n1, int n2) {
        int p1 = find(n1), p2 = find(n2);
        if (p1 == p2) return true;
        if (rank[p1] >= rank[p2]) {
            parent[p2] = p1;
            rank[p1]++;
        } else {
            parent[p1] = p2;
            rank[p2]++;
        }
        return false;
    }
}
