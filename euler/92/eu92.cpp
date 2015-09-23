#include <iostream>

using namespace std;

int N;

int fact(int i){
int prod=1;
if(i==0 || i==1){
	return 1;
}else{
	for(int j=2;j<=i;j++){
		prod*=j;
	}
	return prod;
}

}

//given a array representing an interger returns (A+B+C+D)!/(A!B!C!D!)

int permut(int *array , int N ){
	int counter[10];
	int totalsum=0;
	int prodenom=1;

	for (int i=0;i<10;i++){
		counter[i]=0;

	}

	for(int i=0;i<N;i++){
		counter[*(array+i)]++;
	}

	for(int i=0;i<10;i++){
	cout<<" "<<counter[i]<<" ";
	totalsum+=counter[i];
	prodenom*=fact(counter[i]);
	}
	totalsum=fact(totalsum);
	cout<<" "<<totalsum<<"  "<<prodenom<<" "<<(totalsum/prodenom);
}

int numsum(int ar[],int length){
	int sum=0;
	for(int i=0;i<length;i++){
		sum+=ar[i]*ar[i];
		sum=sum%1000000007;
	}
}

int main(){

int N;


cin>>N;
int sizeOfBool=(81*N)+1000;
bool boolar[sizeOfBool];

// cout<<boolar[0]<<" -- "<<boolar[1] <<endl;
cout<<"Addings";

for(int i=0;i<sizeOfBool;i++){
	boolar[i]=false;
}

// cout<<boolar[0]<<" "<<boolar[1];
cout<<" DoneAddings";



cout<<"Done it so much.";
// cout<<"Done taking input";
// permut(numarray);
return 0;


}



