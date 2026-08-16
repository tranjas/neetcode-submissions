class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && dfs(i)) return false;
        }
        return true;
    }

    public boolean dfs(int course) {
        if (visiting.contains(course))return true;
        if (visited.contains(course)) return false;
        visiting.add(course);
        for (int pre : map.getOrDefault(course, new ArrayList<>())) {
            if (dfs(pre)) return true;
        }
        visited.add(course);
        visiting.remove(course);
        return false;
    }
}
