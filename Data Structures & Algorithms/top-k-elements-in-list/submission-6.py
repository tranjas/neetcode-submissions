class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = {}
        for num in nums:
            if num not in freq:
                freq[num] = 0
            freq[num] += 1
        l = []
        for num, count in freq.items():
            l.append((count,num))
        l.sort()
        result = []
        for i in range(k):
            result.append(l.pop()[1])
        return result