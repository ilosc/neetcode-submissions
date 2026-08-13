class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        record = {}
        for c in s:
            if c not in t:
                return False
            record[c] = record.get(c, 0) + 1
        for c in t:
            if c not in s:
                return False
            record[c] = record.get(c, 0) - 1
        for v in record.values():
            if v != 0:
                return False
        return True
