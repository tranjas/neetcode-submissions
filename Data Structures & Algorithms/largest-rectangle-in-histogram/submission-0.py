class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        result = 0

        for i in range(len(heights)):
            start = i

            while stack and stack[-1][1] > heights[i]:
                index, height = stack.pop()
                result = max(result, (i - index) * height)
                start = index

            stack.append((start, heights[i]))

        while stack:
            index, height = stack.pop()
            result = max(result, (len(heights) - index) * height)

        return result