class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        out = []
        cache = {}
        for word in strs:
            counter = [0] * 26
            for c in word:
                counter[ord(c) - 96] += 1
            key = tuple(counter)
            idx = cache.get(key);
            if idx is not None:
                out[idx].append(word)
            else:
                out.append([word])
                cache[key] = len(out) - 1
        return out        
        