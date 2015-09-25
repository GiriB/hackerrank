x1,y1,x2,y2=map(int,raw_input().split())


a=x1-x2
b=y1-y2

if((a<=0 and b<=0) or (a>=0 and b>=0)):
	if(a>=0 and b>=0):
		print(max(a,b))
	else:
		a=(-a)
		b=(-b)	
		print(max(a,b))
	# normal
elif(a<0):
	ans=0
	adash=(-a)
	if(adash<=b):
		b=b-adash
		ans=2*adash+b
	else:
		adash-=b
		ans=2*b+adash

	print ans	
elif(b<0):
	ans=0
	bdash=(-b)
	if(bdash<=a):
		a=a-bdash
		ans=2*bdash+a
	else:
		bdash-=a
		ans=2*a+bdash
	print ans
else:
	print("Error")