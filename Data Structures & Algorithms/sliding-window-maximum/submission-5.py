class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if k > len(nums):
            return []
        heap = []
        heapq.heapify_max(heap)
        for i in range(0, k):
            heapq.heappush_max(heap, [nums[i], i])
        result = [heap[0][0]]
        l = 1
        for i in range(k, len(nums)):
            heapq.heappush_max(heap, [nums[i], i])
            while heap[0][1] < l:
                heapq.heappop_max(heap)
            result.append(heap[0][0])
            l += 1
        return result

        