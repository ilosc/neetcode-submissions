class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        groups = defaultdict(list)
        base = ord("a")

        for word in strs:
            count = [0] * 26

            for char in word:
                count[ord(char) - base] += 1

            groups[tuple(count)].append(word)

        return list(groups.values())        
        