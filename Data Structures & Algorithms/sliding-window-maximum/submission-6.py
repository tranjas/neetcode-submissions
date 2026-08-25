class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        heap = []
        heapq.heapify_max(heap)
        result = []
        for i in range(len(nums)):
            heapq.heappush_max(heap, [nums[i], i])
            if i >= k - 1:
                while heap[0][1] <= i - k:
                    heapq.heappop_max(heap)
                result.append(heap[0][0])
            
        return result

        