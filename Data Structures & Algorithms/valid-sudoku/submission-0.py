class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        board_rows = defaultdict(set)
        board_cols = defaultdict(set)
        quadrants = defaultdict(list)
        for i, row in enumerate(board):
            for j, value in enumerate(row):
                if value == '.':
                    continue

                value = int(value)

                if value in board_rows[i]:
                    return False
                board_rows[i].add(value)

                if value in board_cols[j]:
                    return False
                board_cols[j].add(value)

                idx = str(i // 3) + str(j // 3)
                if value in quadrants[idx]:
                    return False
                quadrants[idx].append(value)
        return True


                