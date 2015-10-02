T=int(raw_input())


while(T>0):
	N,K=map(int,raw_input().split())
	
	NUM=int(raw_input())
	l=str(NUM)
	largprod=0

	prod=1
	count=0

	for i in range(len(l)):
		# If the num is zero we skip
		if(int(l[i])==0):
			prod=0
			count=0
			continue
		
		if(prod==0):
			prod=1
		prod*=int(l[i])
		if(count!=K):
			count+=1

		if(count==K):
			if(prod>largprod):
				largprod=prod
			prod/=int(l[i-K+1])

	print largprod
	T-=1