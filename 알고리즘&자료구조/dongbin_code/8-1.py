#피보나치 수열을 함수로 표

def fibo(x):
    if x == 1 or x == 2:
        return 1
    return fibo(x - 2) + fibo(x - 1)


print(fibo(4))
