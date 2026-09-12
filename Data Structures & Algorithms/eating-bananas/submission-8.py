class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        result = 0
        while left <= right:
            mid = left + ((right - left) // 2)
            curr = 0
            for pile in piles:
                curr += math.ceil(pile / mid)
            if curr <= h:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result

