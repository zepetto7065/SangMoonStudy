'''
함수 만들기

def add(a,b):
    c = a+b
    print(c)

add(3,2)
add(5,12)

def add(a,b):
    c=a+b
    return c

print(add(3, 2))
'''

def add(a, b):
    c = a+b
    d = a-b
    return c,d
print(add(3,2))

#소수 구하기
def isPrime(x):
    for i in range(2, x):
        if x % i == 0 :
            return False
    return True

a=[12,13,7,8,19]
for y in a:
    if isPrime(y):
        print(y, end=' ')





