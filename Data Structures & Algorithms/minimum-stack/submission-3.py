class MinStack:

    def __init__(self):
        self.stack = []
        self.m_stack = []

    def push(self, val: int) -> None:
        self.stack.append(val)
        if self.m_stack and self.m_stack[-1] < val:
            self.m_stack.append(self.m_stack[-1])
        else:
           self.m_stack.append(val)

    def pop(self) -> None:
        self.stack.pop()
        self.m_stack.pop()

    def top(self) -> int:
        return self.stack[-1]

    def getMin(self) -> int:
        return self.m_stack[-1]
