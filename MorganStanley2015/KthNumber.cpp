#include <iostream>

#include<iostream>
#include<cstdio>
#define gc getchar_unlocked

void scanint(int &x)
{
    register int c = gc();
    x = 0;
    for(;(c<48 || c>57);c = gc());
    for(;c>47 && c<58;c = gc()) {x = (x<<1) + (x<<3) + c - 48;}
}

using namespace std;
int main(){
 int N,Q;
 scanint(N);
 scanint(Q);
 // scanf("%d%d",&N,&Q);
 int A[N];
 int B[Q][2];
 int R[Q];
 int count[Q];
 for(int i=0;i<N;i++){
 // scanf("%d",&(A[i]));
 	scanint(A[i]);
 }
	for(int i=0;i<Q;i++){
		scanint(B[i][0]);
		scanint(B[i][1]);
		// cin>>B[i][0]>>B[i][1];
		count[i]=0;
	}

	for(int i=0;i<N;i++){
		for(int j=0;j<Q;j++){
			if(A[i]>=B[j][0]){
				count[j]++;
				if(count[j]==B[j][1]){
					R[j]=A[i];
				}

			}		
		}
	}

	for(int i=0;i<Q;i++){
		// cout<<R[i]<<endl;
		printf("%d\n",R[i]);
	}







return 0;
}
