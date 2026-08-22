class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        operands = []
        operators = set(('+', '-', '*', '/'))
        for t in tokens:
            if t in operators:
                op1 = operands.pop()
                op2 = operands.pop()
                if t == '+':
                    operands.append(op1 + op2)
                elif t == '-':
                    operands.append(op2 - op1)
                elif t == '*':
                    operands.append(op1 * op2)
                elif t == '/':
                    operands.append(int(op2 / op1))
            else:
                operands.append(int(t))
        return operands.pop()

