import sys
input = sys.stdin.readline

N = int(input())
stk = [] # 정수를 저장할 스택

# 문제에서 주어진 명령 다섯가지를 각 조건에 맞게 처리
for _ in range(N):
    cmd = input().strip().split()
    if cmd[0] == "push":
        stk.append(int(cmd[1]))
    elif cmd[0] == "pop":
        print(stk.pop() if stk else -1)
    elif cmd[0] == "size":
        print(len(stk))
    elif cmd[0] == "empty":
        print(0 if stk else 1)
    elif cmd[0] == "top":
        print(stk[-1] if stk else -1)
    
    