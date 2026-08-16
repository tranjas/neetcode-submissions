class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        stack = []

        for i in prices:
            if not stack or i < stack[-1]:
                stack.append(i)
            else:
                result = max(result, i - stack[-1])

        return result