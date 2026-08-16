class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length -  k+ 1];
        Deque<Integer> queue = new ArrayDeque<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            while (!queue.isEmpty() && nums[right] > nums[queue.peekLast()]) {
                    queue.pollLast();
            }
            queue.addLast(right);
            if (queue.peekFirst() < left) {
                queue.pollFirst();
            }
            if (right + 1 >= k) {
                result[right - k + 1] = nums[queue.peekFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}
