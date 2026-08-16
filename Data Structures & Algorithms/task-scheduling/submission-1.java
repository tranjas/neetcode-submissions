class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.addAll(map.values());
        Queue<int[]> queue = new LinkedList<>();
        int result = 0;

        while (!heap.isEmpty() || !queue.isEmpty()) {
            result++;

            if (!heap.isEmpty()) {
                int currentTaskCount = heap.poll() - 1;
                if (currentTaskCount > 0) {
                    queue.offer(new int[]{currentTaskCount, result + n});
                }
            }

            if (!queue.isEmpty() && queue.peek()[1] <= result) {
                heap.offer(queue.poll()[0]);
            }
        }

        return result;
    }
}
