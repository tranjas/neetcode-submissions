class Solution {
    int[] parent, rank;

    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            if(union(edge[0], edge[1])) return new int[]{edge[0], edge[1]};
        }
        return new int[]{};
    }

    public int find(int node) {
        if (parent[node] != node) {  
            parent[node] = find(parent[node]); 
        }
        return parent[node];
    }

    public boolean union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return true;
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
