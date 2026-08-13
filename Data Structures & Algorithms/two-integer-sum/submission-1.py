class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        items = {}
        for i, value in enumerate(nums):
            if ((target - value) in items):
                return [items[target - value], i,]
            items[value] = i
        

