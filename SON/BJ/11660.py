import sys
input = sys.stdin.readline

N, M = map(int, input().split())

D = [[0]*(N+1) for _ in range(N+1)] # 누적합 배열
board = [list(map(int, input().split())) for _ in range(N)] 

# D[i][j] = (1,1)부터 (i,j)까지의 합
for i in range(1, N+1):
    for j in range(1, N+1):
        D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + board[i-1][j-1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())

    print(D[x2][y2]-D[x1-1][y2]-D[x2][y1-1]+D[x1-1][y1-1])