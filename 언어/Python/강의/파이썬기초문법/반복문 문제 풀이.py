'''
1) 1부터 N까지 홀수 출력하기
2) 1부터 N까지 합 구하기
3) N의 약수 출력하기

n = int(input())

for i in range(1,n+1):
    print(i)
    

n = int(input())

for i in range(1, n+1):
    if i % 2 == 1:
        print(i)

n = int(input())
sum = 0
for i in range(1, n+1):
    sum += i

print(sum)


'''
n = int(input())

for i in range(1, n+1):
    if n % i == 0 :
        print(i, end=' ')

        
