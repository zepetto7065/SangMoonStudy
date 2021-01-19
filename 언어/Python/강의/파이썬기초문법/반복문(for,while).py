'''
반복문

a = range(1, 11)
print(list(a))

for i in range(1, 11):
    print(i)


for i in range(10, 0, -2):
    print(i)


i = 1

while True:
    print(i)
    if i==10:
        break
    i+=1


for i in range(1, 11):
 
    if i % 2 == 0 :
        continue

    print(i)
    i+=1
    
    
'''
for i in range(1, 11):
    print(i)
    if i > 15 :
        break
else:
    print(11)
    
