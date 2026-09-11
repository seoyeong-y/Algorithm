def solution(board):
    n = len(board)
    danger = [[0] * n for _ in range (n)]
    
    dx = [1, -1, 0, 0, -1, 1, -1, 1]
    dy = [0, 0, -1, 1, -1, -1, 1, 1]
    
    for x in range(n):
        for y in range(n):
            if board[x][y] == 1:
                danger[x][y] = 1
                
                for i in range(8):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    
                    if (0 <= nx < n) and (0 <= ny < n):
                        danger[nx][ny] = 1
                                   
    count = 0
    for i in range(n):
        for j in range(n):
            if danger[i][j] != 1:
                count += 1
                
    return count