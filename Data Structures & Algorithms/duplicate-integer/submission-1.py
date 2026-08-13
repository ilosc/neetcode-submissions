class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        record = set()
        for item in nums:
            if item in record:
                return True
            record.add(item)
        return False
        