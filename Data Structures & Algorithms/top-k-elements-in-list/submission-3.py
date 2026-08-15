class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = defaultdict(int)
        for n in nums:
            counter[n] = counter[n] + 1
        top = sorted(counter.items(), key=lambda item: item[1])
        return [top[-idx][0] for idx in range(1, k + 1)]
