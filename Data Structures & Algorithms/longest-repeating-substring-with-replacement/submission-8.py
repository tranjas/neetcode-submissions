class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        d = {}
        l, r, result = 0, 0, 0
        while r < len(s):
            if s[r] not in d:
                d[s[r]] = 0
            d[s[r]] += 1
            while r - l + 1 - max(d.values()) > k:
                d[s[l]] -= 1
                l += 1
            result = max (result, r - l + 1)
            r += 1
        return result