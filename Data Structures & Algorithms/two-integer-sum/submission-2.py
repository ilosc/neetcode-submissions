class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        items = {}
        for i, value in enumerate(nums):
            diff = target - value
            if diff in items:
                return [items[diff], i]
            items[value] = i
