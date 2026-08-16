class Solution {
    Set<Integer> set = new HashSet<>();
    int[] parent;
    int[] rank;
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }
        for (int i = 0; i < parent.length; i++) {
            set.add(find(i));
        }
        return set.size();
    }

    public int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);
        if (p1 != p2){
            if(rank[p1] >= rank[p2]) {
                parent[p2] = p1;
                rank[p1]++;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
        }
    }
}
