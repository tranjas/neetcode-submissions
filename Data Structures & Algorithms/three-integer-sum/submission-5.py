class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        r = len(nums) - 1
        result = []
        nums.sort()
        for l in range(len(nums) - 2):
            if l > 0 and nums[l] == nums[l-1]:
                continue
            target = -nums[l]
            curr = l + 1
            r = len(nums) - 1
            while curr < r:
                temp = nums[curr] + nums[r]
                if temp > target:
                    r -= 1
                elif temp < target:
                    curr += 1
                else:
                    result.append([-target, nums[curr], nums[r]])
                    curr += 1
                    r -= 1
                    while curr < r and nums[curr] == nums[curr - 1]:
                        curr += 1
                    while curr < r and nums[r] == nums[r + 1]:
                        r -= 1
        return result 

                    
