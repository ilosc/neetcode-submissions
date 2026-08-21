class MinStack:


    def __init__(self):
        self._data = []
        self._min_stack = []


    def push(self, val: int) -> None:
        self._data.append(val)
        if (not self._min_stack) or (val <= self._min_stack[-1]):
            self._min_stack.append(val)


    def pop(self) -> None:
        val = self._data.pop()
        if val == self._min_stack[-1]:
            self._min_stack.pop()


    def top(self) -> int:
        return self._data[-1]


    def getMin(self) -> int:
        return self._min_stack[-1]
