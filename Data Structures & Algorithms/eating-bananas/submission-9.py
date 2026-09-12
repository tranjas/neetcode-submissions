class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left = 1
        right = max(piles)
        result = 0
        while left <= right:
            mid = left + ((right - left) // 2)
            time = 0
            for pile in piles:
                time += math.ceil(pile / mid)
            if time <= h:
                result = mid
                right = mid - 1
            else:
                left = mid + 1
        return result
            