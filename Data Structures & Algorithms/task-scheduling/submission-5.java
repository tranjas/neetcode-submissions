class Solution {
    public int leastInterval(char[] tasks, int n) {
        int clock = 0;
        Map<Character, Integer> map = new HashMap();
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        Queue<int[]> wait = new LinkedList();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        heap.addAll(map.values());
        while (!heap.isEmpty() || !wait.isEmpty()) {
            clock++;
            if (!heap.isEmpty()) {
                int temp = heap.poll();
                if (temp - 1 != 0) {
                    wait.add(new int[]{temp - 1, n + clock});
                }
            }
            if (!wait.isEmpty() && wait.peek()[1] == clock) {
                heap.add(wait.poll()[0]);
            }
            
        }
        return clock;
    }
}
