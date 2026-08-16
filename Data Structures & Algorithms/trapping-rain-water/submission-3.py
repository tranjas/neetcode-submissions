class Solution:
    def trap(self, height: List[int]) -> int:
        l, r, l_max, r_max, result = 0, len(height) - 1, 0, 0, 0

        while l < r:
            if height[l] >= l_max:
                l_max = height[l]
            else:
                result += l_max - height[l]
            if height[r] >= r_max:
                r_max = height[r]
            else:
                result += r_max - height[r]
            
            if l_max > r_max:
                r -= 1
            else:
                l += 1
        return result


