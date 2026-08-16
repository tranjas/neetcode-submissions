class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {}
        for i in range(len(nums)):
            temp = target - nums[i]
            if temp in m:
                return [m[temp], i]
            m[nums[i]] = i
