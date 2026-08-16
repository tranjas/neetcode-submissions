class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        result = []
        for i in range(0, len(nums) - 2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            target = 0 - nums[i]
            l = i + 1
            r = len(nums) - 1
            while (l < r):
                c = nums[l] + nums[r]
                if (c == target):
                    result.append([nums[i], nums[l], nums[r]])
                    while (l < r and nums[l] == nums[l + 1]):
                        l += 1
                    l += 1
                    while (l < r and nums[r] == nums[r - 1]):
                        r -= 1
                    r -= 1
                elif c < target:
                    l += 1
                else:
                    r -= 1
        return result