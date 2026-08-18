class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lists = []
        table = {}

        max_length = 0
        mod_list = None
        for n in set(nums):
            idx_list_prev = table.get(n - 1)
            idx_list_post = table.get(n + 1)
            if (idx_list_prev is None) and (idx_list_post is None):
                mod_list = [n]
                lists.append(mod_list)
                table[n] = len(lists) - 1
            elif (idx_list_prev is not None) and (idx_list_post is not None):
                mod_list = lists[idx_list_prev]
                for item in lists[idx_list_post]:
                    mod_list.append(item)
                    table[item] = table[n - 1]
                mod_list.append(n)                    
                table[n] = idx_list_prev
            elif (idx_list_prev is None):
                table[n] = idx_list_post
                mod_list = lists[idx_list_post]
                mod_list.append(n)
            else:
                table[n] = idx_list_prev
                mod_list = lists[idx_list_prev]
                mod_list.append(n)

            list_len = len(mod_list)
            if list_len > max_length:
                max_length = list_len

        return max_length