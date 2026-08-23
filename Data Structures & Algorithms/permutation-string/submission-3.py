class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        count_s1 = Counter(s1)
        window = Counter(s2[:len(s1)])

        if window == count_s1:
            return True
        l = 0
        for r in range(len(s1), len(s2)):
            window[s2[r]] += 1
            window[s2[l]] -= 1
            l += 1

            if window == count_s1:
                return True
        return False