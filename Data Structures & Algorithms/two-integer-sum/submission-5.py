class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        m = {} 
        for index, num in enumerate(nums):
            temp = target - num
            if temp in m:
                return [m[temp], index] 
            m[num] = index