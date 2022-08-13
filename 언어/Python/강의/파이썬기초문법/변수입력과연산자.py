'''
변수입력과 연산자
a=input('숫자를 입력하세요 : ')
print(a)

a, b = input('숫자를 입력하세요 : ').split()
print(type(a))
c = a+b
print(type(c))
print(c)

a, b = input("숫자를 입력하세요 : ").split()
a = int(a)
print(type(a))

a, b = map(int, input('숫자를 입력하세요 : ').split())
print(a+b)
print(a-b)
print(a*b)
print(a/b)
print(a//b)
print(a%b)
print(a**b)
'''

a=4.3
b=5
c=a+b
print(type(c))
