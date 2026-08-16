class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int l = 0, r = 0;

        while (r < nums.length) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
                queue.pollLast();
            } 
            queue.offer(r);
            if (l > queue.peekFirst()) {
                queue.pollFirst();
            }
            if (r + 1 >= k) {
                list.add(nums[queue.peekFirst()]);
                l++;
            }
            r++;
            
        }
        int[] array = new int[list.size()];
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
