# 계수정렬
n = int(input())
array = [0] * 1000000

# 가게에 있는 전체 부품을 입력받아서 사용
for i in input().split():
    array[int(i)] = 1

m = int(input())
x = list(map(int, input().split()))

for i in x:
    if array[i] == 1:
        print('yes', end=' ')
    else:
        print('no', end=' ')
