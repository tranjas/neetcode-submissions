class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        result = 0
        for i in s:
            if i - 1 not in s:
                curr_streak = 1
                while (i + 1 in s):
                    curr_streak += 1
                    i += 1
                result = max(result, curr_streak)
        return result