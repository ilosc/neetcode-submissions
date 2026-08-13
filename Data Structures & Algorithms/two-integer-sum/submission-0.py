class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i,vi in enumerate(nums):
            for j,vj in enumerate(nums):
                if ((vi + vj) == target) and (i != j):
                    return [i, j,]
