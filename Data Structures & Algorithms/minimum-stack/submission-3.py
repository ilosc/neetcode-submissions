class MinStack:


    def __init__(self):
        self._data = []
        self._min_stack = []
        self._min_counter = {}


    def push(self, val: int) -> None:
        self._data.append(val)
        if val in self._min_counter:
            self._min_counter[val] += 1
            return
        elif (not self._min_stack) or (val < self._min_stack[-1]):
            self._min_stack.append(val)
            self._min_counter[val] = 1
            return


    def pop(self) -> None:
        val = self._data.pop()
        if val == self._min_stack[-1]:
            self._min_counter[val] -= 1
            if self._min_counter[val] == 0:
                self._min_stack.pop()
                del self._min_counter[val]

    def top(self) -> int:
        return self._data[-1]


    def getMin(self) -> int:
        return self._min_stack[-1]

