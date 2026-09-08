class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures)):
            if not stack:
                stack.append(i)
            while stack and temperatures[stack[-1]] < temperatures[i]:
                val = stack.pop()
                result[val] = i - val
            stack.append(i)
        return result

            