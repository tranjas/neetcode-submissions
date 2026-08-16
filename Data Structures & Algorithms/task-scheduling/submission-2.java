class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(map.values());
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        while (!heap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                int curr = heap.poll() - 1;
                if (curr > 0) {
                    queue.offer(new int[]{curr, n + time});
                }
            }
            if (!queue.isEmpty()) {
                if (queue.peek()[1] <= time) {
                    heap.offer(queue.poll()[0]);
                }
            }
        }
        return time;
    }
}
