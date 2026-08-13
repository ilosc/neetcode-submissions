class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        record = {}
        for item in nums:
            if item in record:
                return True
            record[item] = None
        return False
        