class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = {}
        c = {}
        g = {}

        for x in range(len(board)):
            for y in range(len(board[x])):
                curr = board[x][y]
                if curr == ".":
                    continue
                if x not in r:
                    r[x] = set()
                if y not in c:
                    c[y] = set()
                if (x//3, y//3) not in g:
                    g[(x//3, y//3)] = set()
                if curr in r[x] or curr in c[y] or curr in g[(x//3, y//3)]:
                    return False
                r[x].add(curr)
                c[y].add(curr)
                g[(x//3,y//3)].add(curr)
        return True
