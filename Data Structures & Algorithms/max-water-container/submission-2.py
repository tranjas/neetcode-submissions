class Solution:
    def maxArea(self, heights: List[int]) -> int:
        result = 0
        l = 0
        r = len(heights) - 1
        while (l < r):
            result = max(result, min(heights[l], heights[r]) * (r-l))
            if (heights[l] > heights[r]):
                r -= 1
            else:
                l += 1
        return result