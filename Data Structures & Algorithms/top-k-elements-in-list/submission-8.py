"""Expected solution. Based on the 'bucket' approach."""
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = defaultdict(int)
        freq = [[] for _ in range(len(nums) + 1)]

        for num in nums:
            counter[num] = counter[num] + 1
        
        for num, times in counter.items():
            freq[times].append(num)
        
        top_rank = []
        for idx in range(len(freq) - 1, 0, -1):
            for item in freq[idx]:
                top_rank.append(item)
                if len(top_rank) == k:
                    return top_rank
        

        