class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
            size = len(nums)
            prefix = [0] * size
            prev = 1
            for i in range(size):
                prefix[i] = prev
                prev *= nums[i]
            
            suffix = [0] * size
            prev = 1
            for i in range(size - 1, -1, -1):
                suffix[i] = prev
                prev *= nums[i]
            
            result = []
            for i in range(size):
                result.append(prefix[i] * suffix[i])
            return result





        