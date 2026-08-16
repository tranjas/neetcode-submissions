class Solution {
    Map<Integer, List<Integer>> map = new HashMap();
    Set<Integer> visiting = new HashSet();
    Set<Integer> visited = new HashSet();
    List<Integer> result = new ArrayList();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] pre : prerequisites) {
            map.putIfAbsent(pre[0], new ArrayList<>());
            map.get(pre[0]).add(pre[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited.contains(i) && detectCycle(i)) {
                return new int[]{};
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean detectCycle(int course) {
        if(visiting.contains(course)) return true;
        if(visited.contains(course)) return false;
        visiting.add(course);
        for (int pre : map.getOrDefault(course, new ArrayList<>())) {
            if (detectCycle(pre))return true;
        }
        visited.add(course);
        visiting.remove(course);
        result.add(course);
        return false;
    }
}
