class Solution {
    private int[] parent, rank;
    public boolean validTree(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        boolean invalid = false;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            if (union(edge[0], edge[1])) invalid = true;
        }
        int temp = parent[0];
        for (int i = 1; i < n; i++) {
            if (temp != parent[i]) return false;
        }
        return !invalid;
    }

    public int find(int node) {
        if (parent[node] != node) {  
            parent[node] = find(parent[node]); 
        }
        return parent[node];
    }

    public boolean union(int n1, int n2) {
        if(find(n1) == find(n2)) return true;
        if (rank[n1] >= rank[n2]) {
            parent[n2] = parent[n1];
            rank[n1]++;
        } else {
            parent[n1] = n2;
            rank[n2]++;
        }
        return false;
    }
}
