class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = defaultdict(int)
        for n in nums:
            counter[n] = counter[n] + 1
        top = sorted(counter.items(), key=lambda item: item[1])
        result = []
        for idx in range(1, k + 1):
            result.append(top[-idx][0])
        return result
        
        # top_elements = [0] * k
        # top_freq   = [-1001] * k
        # counter.sort(counter.items, )
        #     for idx, freq in enumerate(top_freq):
        #         if counter[n] > freq:
        #             top_elements[idx], top_freq[idx] = n, counter[n]
        #             break
        # return top_elements
        