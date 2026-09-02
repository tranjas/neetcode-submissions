class Solution:
    def isValid(self, s: str) -> bool:
        d = {
            "[": "]",
            "{": "}",
            "(": ")"
        }
        stack = []
        for i in s:
            if i in d:
                stack.append(d[i])
            else:
                if not stack or stack[-1] != i:
                    return False
                stack.pop()
        return not stack
