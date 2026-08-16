class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        charSet = set(s)
        result = 0
        for c in charSet:
            l = 0
            count = 0
            for i in range(len(s)):
                if s[i] == c:
                    count += 1
                while i - l + 1 - count > k:
                    if s[l] == c:
                        count -= 1
                    l += 1
                result = max(result, i - l + 1)
        return result