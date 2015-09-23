#This version uses a only single list for all the test cases 
list=[1,2]

def sum(num):
	global list
	tsum=2
	i=1
	chance=4
	while(list[i]<num):
		# Checking if we have already calulated the next symbol or not 
		if(len(list)==i+1):
			list.append(list[i-1]+list[i])
		i+=1
		if(list[i]>num):
			break
		if(i==chance):
			tsum+=list[i]
			chance+=3
	
	return tsum		



T=int(raw_input())

while T>0:
	find=int(raw_input())
	print(sum(find))
	T-=1


# if(list[end]<find):
# 	print("We have to go forth")

# else:
# 	while(index==-1):
# 		mid=(start+end)/2
# 		print(start,end,mid)
		
# 		if(start==end or start+1==end):
# 			index=start
# 		if(find<list[mid]):
# 			end=mid
# 		if(find>list[mid]):
# 			start=mid
# 	print("Index is ",index)
# 	print (list[index-1],list[index],list[index+1])
