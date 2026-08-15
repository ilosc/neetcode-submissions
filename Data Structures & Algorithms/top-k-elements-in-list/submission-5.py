class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = defaultdict(int)
        top_rank = [-1001] * k
        for num in nums:
            counter[num] = counter[num] + 1
            if num in top_rank:
                continue
            for idx, item in enumerate(top_rank):
                if counter[num] > counter.get(item, 0):
                    top_rank[idx] = num
                    break
        return top_rank
