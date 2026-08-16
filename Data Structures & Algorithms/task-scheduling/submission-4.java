class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for (char c : tasks) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a,b)-> b-a);
        heap.addAll(map.values());
        Queue<int[]> queue = new LinkedList();
        int cycle = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            cycle++;
            if (!heap.isEmpty()) {
                int curr = heap.poll() - 1;
                if (curr > 0) {
                    queue.add(new int[]{curr, cycle + n});
                }
            }
            if (!queue.isEmpty() && queue.peek()[1] == cycle) {
                heap.add(queue.poll()[0]);
            }
        }
        return cycle;
    }
}
