class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b)-> b-a);
        for (int num : nums) {
            queue.add(num);
        }
        for(int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}
