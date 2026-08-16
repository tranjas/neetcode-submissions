class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        heap.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }
}
