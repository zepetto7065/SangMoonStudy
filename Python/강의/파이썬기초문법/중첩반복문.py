'''
2중 for문


for i in range(5):
    print("i:",i,sep='',end=' ')
    for j in range(i):
        print("*",end=' ')
    print()
'''

for i in range(5):
    for j in range(5-i):
        print("*", end=' ')
    print()
