import math 

# def rety(m,x,):
# 	y=m*x+yold
# 	return y
# def retx(m,y,yold):
# 	y=m*x+yold
# 	return y
	
# dist = math.hypot(x2 - x1, y2 - y1)
dist=float()
L,B,R,X=map(float,raw_input().split())

m=1


L=round(L-2*R,6)
B=round(B-2*R,6)

xold=round(X-R,6)
yold=0

ynew=round(m*(L-xold)+0,6)
xnew=L



if(ynew<B):
	while(ynew<B):
		dist+=round(math.hypot(xnew - xold, ynew - yold),6)
		# print(xnew,ynew)
		yold=ynew
		xold=xnew
		m*=-1 #change direction 
		if m==1:
			ynew=round(m*(L-xold)+yold,6)
		if m==-1:
			ynew=round(m*(0-xold)+yold,6)

	xnew=round(((B-yold)/m)+xold,6)
	# print(xnew,ynew)
	dist+=round(math.hypot(xnew - xold, B - yold),6)
else:
	xnew=round((B/m)+xold,6)
	dist+=round(math.hypot(xnew - xold, B - 0),6)

print '{0:.6f}'.format(dist)
# print '{number:.{digits}f}'.format(dist=dist, digits=6)


