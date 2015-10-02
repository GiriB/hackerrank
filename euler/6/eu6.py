T=int(raw_input())
while(T >0):
	N=int(raw_input())
	sumsq=0
	sum=0	
	sumsq = (N * (N + 1) * (2 * N + 1)) / 6
	sum = (N) * (N + 1) / 2
	sum*=sum
	print(sum-sumsq)
	T-=1