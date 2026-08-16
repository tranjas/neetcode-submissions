class Solution:
    def isPalindrome(self, s: str) -> bool:
        t = ''.join(c.lower() for c in s if c.isalnum())
        l = 0
        r = len(t) - 1
        while (l <= r):
            if t[l] != t[r]:
                return False
            l += 1
            r -= 1
        return True