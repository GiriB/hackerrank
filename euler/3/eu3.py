T=int(raw_input())
while(T>0):
	num=int(raw_input())
	largfact=1
	i=2
	while(i*i <= num):
		if(num%i==0):
			num=num/i
			largfact=i
		else:
			i+=1
	print max(largfact,num)
	T-=1