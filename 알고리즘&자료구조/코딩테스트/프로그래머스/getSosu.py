x = int(input())
answer = 0
def getSosu(x):
  if x != 1 :

    for i in x :
      for j in range(2,i):
        if i % j == 0 :
          answer = answer + 1
          return False
    return answer
print(answer)