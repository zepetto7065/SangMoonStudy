'''
리스트와 내장함수(2)
'''

a=[23,12,36,53,19]
print(a[:3])
print(a[1:4])
print(len(a))

for i in range(len(a)):
    print(a[i], end=' ')
print()

for x in a:
    print(x, end= ' ')
print()

for x in a:
    if x % 2 == 0:
        print(x, end=' ')
print()
#index까지
for x in enumerate(a):
    print(x)

#튜플은 변경 불가
b=(1,2,3,4,5)
print(b[0])

for x in enumerate(a):
    print(x[0], x[1])
print()

for index, value in enumerate(a):
    print(index, value)
print()

#전부 참이어야 할떄
if all(50>x for x in a):
    print("Yes")
else:
    print("No")

#한번이라도 참이면
if any(17>x for x in a):
    print("Yes")
else:
    print("No")

