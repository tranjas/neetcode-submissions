class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = 0
        r = len(numbers) - 1
        while (l < r):
            c = numbers[l] + numbers[r]
            if  numbers[l] + numbers[r] == target:
                return [l + 1, r + 1]
            elif c < target:
                l += 1
            else:
                r -= 1