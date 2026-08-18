class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numbers = set(nums)
        longest = 0

        for n in numbers:
            # Solo comenzamos desde el inicio de una secuencia
            if n - 1 not in numbers:
                length = 1

                while n + length in numbers:
                    length += 1

                longest = max(longest, length)

        return longest        