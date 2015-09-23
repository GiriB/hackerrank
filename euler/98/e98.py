import math
n=raw_input()
n=int(n)
count=0
dict={}
for i in range (1,int((math.pow(10,n)+1)%(10000007))):
	sum=i
	hashstr=str(i)
	l=[]
	#print(i,l)
	while(sum!=89 and sum!=1):
		if(hashstr in dict):
			if(dict[sum]==89):
				sum=89
			elif(dict[sum]==1):
				sum=1
		else:	
			l.append(sum)
			#print("l ",l)
			stra=[i for i in str(sum) ]
			sum=0
			for i in stra:
				sum+=int(i)*int(i)
	if(sum==89):
		for i in l:
			dict[i]=89
		count=(count)%10000007+1
	elif(sum==1):
		for i in l:
			dict[i]=1
		

print(count)
