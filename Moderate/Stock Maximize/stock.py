

T = int(raw_input())

while(T>0):
	stock=[]
	size=int(raw_input())
	stock=map(int,raw_input().split())
	print(len(stock))
	netprofit=0
	count=size-1
	max_till_now=0
	while(count>-1):
		# print("inside")
		max_till_now = max(max_till_now, stock[count])
		netprofit =netprofit + max_till_now - stock[count]
		count-=1
	print(netprofit)
	T-=1