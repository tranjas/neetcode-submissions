class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        if s == t:
            return s

        l, r = 0, 0
        r_size = float("inf")
        result = ""
        window = Counter()
        goal = Counter(t)
        have = 0
        need = len(goal)
        while r < len(s):
            c = s[r]
            window[c] += 1

            if c in goal and window[c] == goal[c]:
                have += 1

            while have == need:
                if r - l + 1 < r_size:
                    r_size = r - l + 1
                    result = s[l : r + 1]
                c_left = s[l]
                window[c_left] -= 1
                if c_left in goal and window[c_left] < goal[c_left]:
                    have -= 1
                l += 1
            r += 1
        return result