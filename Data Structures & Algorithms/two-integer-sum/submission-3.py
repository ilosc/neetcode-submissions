class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        items = {}
        for i, value in enumerate(nums):
            j = items.get(target - value)
            if j is not None:
                return [j, i]
            items[value] = i        