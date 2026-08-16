class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
      s = set(nums)
      m = 0
      for i in nums:
        curr = 1
        if i - 1 not in s:
            while i + 1 in s:
               curr += 1
               i += 1
        m = max(curr, m)
      return m
       
