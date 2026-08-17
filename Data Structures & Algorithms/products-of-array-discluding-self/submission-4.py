class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
            size = len(nums)
            prefix = [0] * size
            prev = 1
            for i in range(size):
                prefix[i] = prev
                prev *= nums[i]
            
            result = [0] * size
            suffix = 1
            for i in range(size - 1, -1, -1):
                result[i] = prefix[i] * suffix
                suffix *= nums[i]
            return result
