class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = []
        result = 0
        for i in range(len(heights)):
            start = i
            while stack and heights[i] < stack[-1][1]:
                temp = stack.pop()
                result = max(result, (i - temp[0]) * temp[1])
                start = temp[0]
            stack.append((start, heights[i]))
        while stack:
            temp = stack.pop()
            result = max(result, (len(heights) - temp[0]) * temp[1])
        return result