class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Max-heap to get the most frequent task first
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        heap.addAll(map.values());

        int result = 0;
        // Queue to store tasks during their cooldown period
        Queue<int[]> cooldown = new LinkedList<>();

        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            result++;

            if (!heap.isEmpty()) {
                int currentTaskCount = heap.poll() - 1;
                if (currentTaskCount > 0) {
                    cooldown.add(new int[]{currentTaskCount, result + n});
                }
            }

            // If a task's cooldown has ended, add it back to the heap
            if (!cooldown.isEmpty() && cooldown.peek()[1] == result) {
                heap.add(cooldown.poll()[0]);
            }
        }

        return result;
    }
}
