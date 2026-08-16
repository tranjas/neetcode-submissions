class Solution:
    def trap(self, height: List[int]) -> int:
        l, l_max, r, r_max, result = 0, 0, len(height) - 1, 0,0

        while l < r:
            if height[l] < l_max:
                result += l_max - height[l]
            else:
                l_max = height[l]
            if height[r] < r_max:
                result += r_max - height[r]
            else:
                r_max = height[r]
            if l_max > r_max:
                r -= 1
            else:
                l += 1
        return result