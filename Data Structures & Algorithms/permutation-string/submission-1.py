from collections import Counter

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        s1_count = Counter(s1)
        window = Counter(s2[:len(s1)])

        if s1_count == window:
            return True

        l = 0

        for r in range(len(s1), len(s2)):
            window[s2[r]] += 1
            window[s2[l]] -= 1
            l += 1

            if s1_count == window:
                return True

        return False