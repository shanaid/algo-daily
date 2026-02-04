import sys
input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
x = int(input())

nums.sort()

left = 0
right = len(nums)-1
cnt = 0

while left < right :
    if nums[left] + nums[right] > x :
        right -= 1
    elif nums[left] + nums[right] == x :
        cnt += 1
        left += 1
        right -= 1
    elif nums[left] + nums[right] < x :
        left += 1

print(cnt)