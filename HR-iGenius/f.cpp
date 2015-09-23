#include <iostream>
#include <cmath>
#include <cstdio>
#include <iomanip>
using namespace std;

double Distance(double dX0, double dY0, double dX1, double dY1)
{
    return sqrt((dX1 - dX0)*(dX1 - dX0) + (dY1 - dY0)*(dY1 - dY0));
}

int main(){

	double L,B,R,X;
	 double dist;
	cin>>L>>B>>R>>X;
	int m=1;
	 double xold,xnew,yold,ynew;

	L=L-2*R;
	B=B-2*R;

	xold=X-R;
	yold=0;

	ynew=m*(L-xold)+0;
	xnew=L;


	if(ynew<B){
		while(ynew<B){
			dist+=Distance(xnew,ynew,xold,yold);
			// # print(xnew,ynew)
			yold=ynew;
			xold=xnew;
			m*=-1;
			 // #change direction 
			if (m==1){
				ynew=m*(L-xold)+yold;
			}
			if (m==-1){
				ynew=m*(0-xold)+yold;
			}			
		}
		xnew=((B-yold)/m)+xold;
		// # print(xnew,ynew)
		dist+=Distance(xnew,B,xold,yold);
	}
	else{
		xnew=(B/m)+xold;
		dist+=Distance(xnew,B,xold,0);
	}
cout << setprecision (3) << fixed << dist;

}