x = int(input('please input number'))

#소수 구하기
def getSosu(x): 
	
	answer = 0
	
	if x < 2 :
		return "x is less than two"	
	else:
	
		for i in range(1, x+1):
			chk = 0 #약수의 개수
			
			for j in range(1,i+1):
				if i % j == 0 :
					chk += 1
					
			#1을 제외한 자기 자신이 약수가 될떄 
			if chk == 2 :
				answer += 1
					
		return answer

print(getSosu(x))
