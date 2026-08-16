class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        se = set()
        l, r, result = 0, 0, 0
        while r < len(s):
            while s[r] in se:
                se.remove(s[l])
                l += 1
            se.add(s[r])
            result = max(result, len(se))
            r += 1
        return result