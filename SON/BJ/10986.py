import sys
input = sys.stdin.readline

# N : 수의 개수, M : 나누는 값 (M으로 나누어 떨어지는 구간합의 개수를 구해야 함)
N, M = map(int, input().split())
nums = list(map(int, input().split()))

# C[r] = 누적합을 M으로 나눈 나머지가 r인 개수
C = [0] * M

prefix = 0 # 누적합 % M
answer = 0 # M으로 나누어 떨어지는 구간 개수 = 답

for x in nums:
    prefix = (prefix + x) % M
    if prefix == 0 :
        answer += 1
    C[prefix] += 1

# 같은 나머지끼리 2개 고르면 그 사이 구간은 M의 배수
for i in range(M):
    if C[i] > 1 :
        answer += (C[i]*(C[i]-1)//2)
print(answer)