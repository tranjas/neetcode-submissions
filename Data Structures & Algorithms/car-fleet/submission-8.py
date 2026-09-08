class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        ar = [[position[i], speed[i]] for i in range(len(position))]
        ar.sort(reverse=True)
        stack = []
        result = 0
        for i in range(len(ar)):
            t_curr = (target - ar[i][0]) / ar[i][1]
            if stack and t_curr <= stack[-1]:
                continue
            stack.append(t_curr)
        return len(stack)

            

