class Solution:

    def isValid(self, s: str) -> bool:
        stack = []
        symbols = {')': '(', '}': '{', ']': '['}

        open_symbols = set(symbols.values())
        for c in s:
            if c in open_symbols:
                stack.append(c)
            else:
                # Close char
                if (not stack) or (symbols.get(c) != stack.pop()):
                    return False
        else:
            if stack:
                return False
        return True
          
            
        