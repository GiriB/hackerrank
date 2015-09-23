import math 

dist=float()
L,B,R,X=map(float,raw_input().split())
dist=0
yold=R
xold=X
m=1
ynew=(L-R-xold)+yold
xnew=L-R

if(ynew<B-R):
	dist+=math.hypot(xnew - xold, ynew - yold)
	yold=ynew
	xnew=xold
	m*=-1
	if(m==1):

	if(m==-1):
		ynew=xold-R+yold
		xnew=