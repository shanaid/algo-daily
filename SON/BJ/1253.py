import sys
input = sys.stdin.readline

N = int(input())
nums = list(map(int, input().split()))
nums.sort()

cnt = 0
for i in range(N):
    left = 0
    right = N - 1
    while left < right:
        # target index 제외
        if left == i:
            left += 1
            continue
        if right == i:
            right -= 1
            continue

        pair_sum =  nums[left] + nums[right]

        if pair_sum < nums[i]:
            left += 1
        elif pair_sum > nums[i]:
            right -= 1
        else:
            cnt += 1
            break  
print(cnt)