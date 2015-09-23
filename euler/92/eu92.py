import timeit
# start = timeit.timeit()

# bool array of sum uptil 81*num
bool89=[]
result=0

# convert a num to sqr sum
def numsum(num):
	sum=0
	for i in str(num):
		sum+=int(i)*int(i)
	return sum%1000000007


# tells if the  list of digits' sqr sum would lead upto 89 or not 
#input is ['1','2','1'] for 121
def listSumIs89(list):
	sum=0
	for i in list:
		sum+=int(i)*int(i)
	# print("The sum is ",sum)	
	return bool89[sum]

#create all unique arrays from 0 to N digit 9999...
def calcunique(N):
	res=0
	N=int(N)
	array=[]
	for i in range(0,N):
		array.append(0)
	i=N-1
	while (True):
		
		if (i == 0 and array[i] == 9):
			break
		if(i == N - 1 and array[i] < 9):
			# //Increase the last array
			array[i]+=1
			# print array
			if(listSumIs89(array)):
				res+=combinator(array)
				res=res%1000000007

			# result += CheckNumber(array)
		elif(array[i] == 9):
			# //we reach max, so move back
			i-=1
		else:
	        # //Increase a digit
			array[i]+=1
			# //Move to the end
			for j in range(i+1,N):
				array[j] = array[i]
			i = N - 1
			# print array
			if(listSumIs89(array)):
				res+=combinator(array)
				res=res%1000000007

	        # result += CheckNumber(array)
	return res
	
	

	




#given a list of num calculate (A+B+C+D)!/(A!B!C!D!)

def combinator(num):
	dict={}
	for i in num:
		if(dict.has_key(i)):
			dict[i]=dict[i]+1
		else:
			dict[i]=1
	denomfact=1
	for i in dict:
		denomfact*=fact(dict[i])		
	ans = fact(len(num))/(denomfact)
	return ans%1000000007


#factorial
def fact(num):
	 ans=1
	 num=int(num)
	 for i in range (1,num+1):
	 	ans*=i
	 return ans%1000000007


# get Int
# print("Helo")
N=int(raw_input())
# num terminating at 89
eightynine=0 

#initialising the array
for i in range(0,(81*N)+1000):
	bool89.append(-1)
bool89[1]=False
bool89[89]=True

#filing up the table with True and False
for i in range(1,(81*N)+1000):
	l=[]
	sum=numsum(i)
	l.append(i)
	if(i==1 or i==89):
		pass
	else:
		while(bool89[sum]!=True and bool89[sum]!=False):
			l.append(sum)
			sum=numsum(sum)
		if(bool89[sum]==True):
			for i in l:
				bool89[i]=True
		else:
			for i in l:
				bool89[i]=False

# //print bool89
print(calcunique(N)%1000000007)

# for i in range (1,81*N):
# 	print(i," is ", bool89[i])


# end = timeit.timeit()
# print("The time is ",end-start)

