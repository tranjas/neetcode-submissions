class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            if num not in freq:
                freq[num] = 0
            freq[num] += 1
        heap = []
        heapq.heapify(heap)
        for num, count in freq.items():
            heapq.heappush(heap, (count, num))
            if (len(heap) > k):
                heapq.heappop(heap)
        return [num for count, num in heap]