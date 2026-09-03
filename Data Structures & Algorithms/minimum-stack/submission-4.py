class MinStack:

    def __init__(self):
        self.stack = []
        self.m = float('inf')

    def push(self, val: int) -> None:
        if not self.stack:
            self.stack.append(0)
            self.m = val
        else:
            self.stack.append(val - self.m)
            if val < self.m:
                self.m = val

    def pop(self) -> None:
        if not self.stack:
            return

        if self.stack[-1] < 0:
            self.m = self.m - self.stack[-1]
        self.stack.pop()

    def top(self) -> int:
        top = self.stack[-1]
        if top > 0:
            return top + self.m
        else:
            return self.m

    def getMin(self) -> int:
        return self.m
