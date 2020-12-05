# 큰수의 법칙
# 2 <= N <= 1000
# 1 <= M <= 10000
# 1 <= K <= 10000
# N 배열의 크기 M 더해지는 횟수 K 연속 허용의 개수
# 5 8 3
# 2 4 5 4 6

# 입력을 받는다
n, m, k = map(int, input().split())
# N개의 수를 공백으로 구분하여 받는다
data = list(map(int, input().split()))
# 가장 큰 수와 다음으로 큰 수를 뽑는다 
data.sort();
first = data[n-1]
second = data[n-2]

result = 0
# 가장 큰 수를 K번 그리고 다음으로 큰 수를 1번 더한다.
while True:
  for i in range(k):
    if m == 0 :
      break
    result += first
    m -= 1
  if m == 0 :
    break
  result += second
  m -= 1


print(result)


