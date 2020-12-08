# 재귀함수를 이용한 이진탐색
def binary_search(array, target, start, end):
    if start > end :
        return None
    mid = (start + end) // 2
    # 중간점에 있을 경
    if array[mid] == target:
        return mid
    # 중간점의 값보다 찾고자하는 값이 작은 경우
    elif array[mid] > target:
        binary_search(array, target, 0, mid - 1)
    elif array[mid] < target:
        binary_search(array, target, mid + 1, end)


# 개수와 target input
n, target = list(map(int, input().split()))

# 탐색할 대상 input
array = list(map(int, input().split()))

result = binary_search(array, target, 0, n - 1)

if result is None:
    print("원소가 존재하지 않습니다.")
else:
    print(result + 1)
