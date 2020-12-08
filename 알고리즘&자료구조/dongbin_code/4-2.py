n = int(input())
#1분 60초
#1시간 60분
#하루 24시간
#N시 00분 00초
#포함
#이런경우 String으로 변환하여 포함되어 있는지를 check한다.

count = 0
for i in range(1+n):
  for j in range(60):
    for k in range(60):
      if '3' in str(i) + str(j) + str(k) :
        count+=1

print(count)