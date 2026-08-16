class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l,r, result = 0, 0 , 0
        count = {} 
        while r < len(s):
            if s[r] not in count:
                count[s[r]] = 0
            count[s[r]] += 1
            while r - l + 1 - max(count.values()) > k:
                count[s[l]] -= 1
                l += 1
            result = max (result, r - l + 1)
            r += 1
        return result