n, m = list(map(int, input().split(' ')))  # n : 떡의 개수 , m : 일정한 떡의 길이 // 4, 6
array = list(map(int, input().split()))  # 떡의 길이 list // 19, 15, 10, 17

start = 0
end = max(array)

result = 0
while start <= end:
    total = 0
    mid = (start + end) // 2
    # 떡 자르기
    for x in array:
        if x > mid:
            total += x - mid
    # 떡의 양이 부족한 경우 , 더많이 자르기 ( 왼쪽 부분 )
    if total < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)
