class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if s == t:
            return s
        if len(t) > len(s):
            return ""
        goal = Counter(t)
        window = Counter()
        result, result_len, l, have, need = "", float("inf"), 0, 0, len(goal)
        for r in range(len(s)):
            c = s[r]
            window[c] += 1
            if c in goal and window[c] == goal[c]:
                have += 1
                while have == need:
                    if result_len > (r - l + 1):
                        result = s[l: r + 1]
                        result_len = r - l + 1
                    left_c = s[l]
                    window[left_c] -= 1
                    if left_c in goal and window[left_c] < goal[left_c]:
                        have -= 1
                    l += 1
        return result
