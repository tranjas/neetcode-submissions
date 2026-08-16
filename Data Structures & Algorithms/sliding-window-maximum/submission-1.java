class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> d = new ArrayDeque<>();
        int l = 0, r = 0;

        while (r < nums.length) {
            while (!d.isEmpty() && nums[d.peekLast()] < nums[r]) {
                d.pollLast();
            }
            d.offerLast(r);

            if (d.peekFirst() < l) {
                d.pollFirst();
            }

            if (r + 1  >= k ) {
                result[r+ 1-k] = nums[d.peekFirst()];
                l++;
            }
            r++;
        }
        return result;
    }
}
