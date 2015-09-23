#include <iostream>
#include <list>
#include<vector>
#include <math.h>
using namespace std;

double permut(int *);
int numsum(int *);
//global variable
int N = 1;

// checks if the given list of integers sums up to 89 or not
int isSum89(int *array, int * boolar) {
	int sum = numsum(array);
	return boolar[sum];
}

double calcUnique(int num, int *boolar) {
	double res = 0;
	int array[N];
	for (int i = 0; i < N; i++) {
		array[i] = 0;
	}

	int i = N - 1;
	while (true) {
		if (i == 0 and array[i] == 9) {
			break;
		}
		if (i == N - 1 && array[i] < 9) {
			array[i] += 1;

			if (isSum89(array, boolar) == 1) {
				res += permut(array);
//				res = res % 1000000007;
			}

		} else if (array[i] == 9) {
			i -= 1;
		} else {
			array[i] += 1;
			for (int j = i + 1; j < N; j++) {
				array[j] = array[i];
			}
			if (isSum89(array, boolar) == 1) {
				res += permut(array);
//				res = res % 1000000007;
			}
			i = N - 1;
		}
	}

	return res;
}

////calculates the factorial of a number
double fact(int i) {
	double prod = 1;
	if (i == 0 || i == 1) {
		return 1;
	} else {
		for (int j = 2; j <= i; j++) {
			prod *= j;
		}
//		cout << "fact of " << i << " is " << prod << endl;
		;
		return prod;
	}

}
//
////given a array representing an integer returns (A+B+C+D)!/(A!B!C!D!)
double permut(int *array) {
	int counter[10];
	double totalsum = 0;
	long long int prodenom = 1;

	for (int i = 0; i < 10; i++) {
		counter[i] = 0;

	}

	for (int i = 0; i < N; i++) {
		counter[*(array + i)]++;
	}

	for (int i = 0; i < 10; i++) {
		totalsum += counter[i];
	}
//	cout << "total sum is " << totalsum;
	totalsum = fact(totalsum);
//	cout << " and fact is " << totalsum << endl;

	for (int i = 0; i < 10; i++) {
		totalsum /= fact(counter[i]);
	}
//	cout << "returning is " << totalsum << endl;
	return (totalsum) ;
}
//
//// given a integer  , return the sum of square of each digit
int numsum(int num) {
	int sum = 0;
	int digit;
	while (num != 0) {
		digit = num % 10;
		sum += digit * digit;
		num = num / 10;
	}
	return sum;
}
//// given a integer array , return the sum of square of each integer
//
int numsum(int *ar) {
	int sum = 0;
//

	for (int i = 0; i < N; i++) {
		sum += ar[i] * ar[i];
		sum = sum % 1000000007;

	}

	return sum;
}

int main() {
	cin >> N;

	int sizeOfBool = (81 * N) + 10;
	int boolar[sizeOfBool];
	for (int i = 0; i < sizeOfBool; i++) {
		boolar[i] = 3;
	}
	boolar[1] = 0;
	boolar[89] = 1;

	vector<int> l;
	int sum = 0;
	for (int i = 1; i < sizeOfBool; i++) {
		l.push_back(i);
		sum = numsum(i);
		if (i == 1 || i == 89) {
			//WE ALREADY HAVE VALUES FILLED IN
			l.clear();
			l.resize(0);
		} else {

			while (boolar[sum] != 0 && boolar[sum] != 1) {
				l.push_back(sum);
				sum = numsum(sum);
			}

			if (boolar[sum] == 1) {
				//give one to all

				for (std::vector<int>::iterator it = l.begin(); it != l.end();
						++it) {
					boolar[*it] = 1;
				}

			}

			if (boolar[sum] == 0) {
				//give 0 to all
				for (std::vector<int>::iterator it = l.begin(); it != l.end();
						++it) {
					boolar[*it] = 0;
				}

			}

			l.clear();
			l.resize(0);
		}

	}

	cout <<(long long)fmod(calcUnique(N, boolar),1000000007) ;
	return 0;

}

