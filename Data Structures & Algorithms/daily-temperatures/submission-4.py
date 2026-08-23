class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        current_max = 0
        result = [0] * len(temperatures)
        for i in range(len(temperatures) - 1, -1, -1):
            t = temperatures[i]
            if t >= current_max:
                result[i] = 0
                current_max = t
                stack = [(i, t)]
                continue

            while stack:
                if t < stack[-1][1]:
                    result[i] = stack[-1][0] - i
                    stack.append((i, t))
                    break
                stack.pop()
        return result