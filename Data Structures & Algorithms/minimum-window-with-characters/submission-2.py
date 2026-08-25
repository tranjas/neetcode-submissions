class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t:
            return s
        if len(t) > len(s):
            return ""
        goal = Counter(t)
        window = Counter()
        need = len(goal)
        have = 0
        l = 0
        result = ""
        result_len = float("inf")
        for r in range(len(s)):
            window[s[r]] += 1
            if s[r] in goal and window[s[r]] == goal[s[r]]:
                have += 1

                while have == need:
                    if result_len > (r - l + 1):
                        result = s[l:r + 1]
                        result_len = r - l + 1

                    window[s[l]] -= 1
                    if s[l] in goal and window[s[l]] < goal[s[l]]:
                        have -= 1
                    l += 1

        return result


