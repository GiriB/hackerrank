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

if B<=2*R:
	dist=0
else:	
	L=L-2*R
	B=B-2*R

	xold=X-R
	yold=0

	ynew=m*(L-xold)+0
	xnew=L

	# print(xnew,ynew,"<-",xold,yold)

	if(ynew<=B):
		while(ynew<=B):
			dist+=math.hypot(xnew - xold, ynew - yold)
			# print(xnew,ynew)
			# print(xnew,ynew,"<-",xold,yold)
			yold=ynew
			xold=xnew
			m*=-1 #change direction 
			if m==1:
				ynew=m*(L-xold)+yold
				xnew=L
			if m==-1:
				ynew=m*(0-xold)+yold
				xnew=0
		xnew=((B-yold)/m)+xold
		# print(xnew,ynew)
		dist+=math.hypot(xnew - xold, B - yold)
	else:
		xnew=(B/m)+xold
		# print(xnew,ynew,"<-",xold,yold)
		dist+=math.hypot(xnew - xold, B - 0)

print '{0:.3f}'.format(dist)
	# print '{number:.{digits}f}'.format(dist=dist, digits=6)


