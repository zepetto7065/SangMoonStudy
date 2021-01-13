'''
2차원 리스트 생성과 접근
'''

#a=[0]*3 #10개의 list 생성
#print(a)

a=[[0]*3 for _ in range(3)] # _ 는 변수없이 for문 돈다.
print(a) # [[0, 0, 0], [0, 0, 0], [0, 0, 0]]

a[0][1]=1
print(a)
a[1][1]=2
print(a)

for x in a:
    print(x)

for x in a:
    for y in x:
        print(y , end=' ')
    print()