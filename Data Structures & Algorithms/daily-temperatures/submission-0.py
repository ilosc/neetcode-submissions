class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        t_max = 0
        stack = []
        result = [0] * len(temperatures)
        for i in range(len(temperatures) - 1, -1, -1):
            t = temperatures[i]
            if t >= t_max:
                result[i] = 0
                t_max = t
            else:
                for j in range(len(stack) - 1, -1, -1):
                    if stack[j][1] > t:
                        result[i] = stack[j][0] - i
                        break
            stack.append((i, t))
        return result
