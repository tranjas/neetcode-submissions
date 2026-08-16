class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue =  new PriorityQueue<>((a,b) -> b-a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                return queue.poll();
            }
            int x = queue.poll();
            int y = queue.poll();
            if (x == y) continue;
            if (x > y) {
                queue.add(x - y);
            }

        }
        return 0;
    }
}
