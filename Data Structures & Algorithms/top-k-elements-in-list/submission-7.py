"""Solución bizarra con muy mal runtime y muy buen memory."""
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        by_number = defaultdict(list)
        counter = defaultdict(int)
        for n in nums:
            count = counter.get(n, 0)
            if count > 0:
                by_number[count].remove(n)
            by_number[count + 1].append(n)
            counter[n] = counter[n] + 1
        top_rank = []
        for idx in range(len(nums), 0, -1):
            for item in by_number[idx]:
                top_rank.append(item)
                if len(top_rank) == k:
                    return top_rank

