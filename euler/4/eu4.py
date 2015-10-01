
T=int(raw_input())

while(T>0):
	N=int(raw_input())
	for i in range(100,1000):
		j=1000*i+ int(str(i)[::-1])
		if(j<N):
			for p in range(100,1000):
				if(j%p==0):
					if(len(str(j/p))==3):
						num=j
	print num
	T-=1