class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l = 0
        r = len(matrix) - 1
        while l <= r:
            mid = l + ((r - l) // 2)
            row_len = len(matrix[0]) - 1
            if target <= matrix[mid][row_len] and target >= matrix[mid][0]:
                left = 0
                right = row_len
                while left <= right:
                    temp = left + ((right - left) // 2)
                    curr = matrix[mid][temp]
                    if curr == target:
                        return True
                    elif curr > target:
                        right = temp - 1
                    else:
                        left = temp + 1
                return False
            elif target < matrix[mid][0]:
                r = mid - 1
            else:
                l = mid + 1
        return False