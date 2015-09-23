num = int(raw_input())
while num>=1:
	a,b=map(int,raw_input().split())
	if b>a:
		a,b=b,a
	# print("In the beg a and b",a,b)
	ans=0
	ans=a/b
	c=b
	b=a%b
	a=c
	# print("new a and b",a,b)
	while(b!=0):
		ans+=a/b
		c=b
		b=a%b
		a=c	
		# print("new a and b",a,b)	

	print ans	

	num-=1