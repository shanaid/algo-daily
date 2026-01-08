import sys
input = sys.stdin.readline

T = int(input())


for _ in range(T):
    line = input().strip() # 입력받는 괄호 문자열
    stack = [] # 여는 괄호 "(" 저장할 스택
    valid = True # 올바른 문자열인지 판단


    for ch in line:
        if ch == "(":
            stack.append(ch) # 여는 괄호 스택에 추가
        elif ch == ")":
            if stack:
                stack.pop() # 닫는 괄호 나오면 대응하는 여는 괄호 1개 제거
            else:
                valid = False
                break
    

    if valid and not stack:
        print("YES")
    else:
        print("NO")
        