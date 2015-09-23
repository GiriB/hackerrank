import math as m
num=int(raw_input())
while num>=1:
	a,b,c=raw_input().split()
	a=float(a)
	b=float(b)
	c=float(c)

	k=int(m.ceil(b**(1/a)))
	l=int(m.floor(c**(1/a)))
	for i in range(k,l+1):
		print int(i),
	num-=1
	print