/*
 
 
 * Thrid_Morgan.cpp
 *
 *  Created on: 25-Sep-2015
 *      Author: girigb
 */
#include <iostream>
#include <stdlib.h>
#include <map>
using namespace std;
void Union(int *, int, int, int);

void Union(int *id, int p, int q, int N) {
//    cout << "In Union" << endl;
    int tmp=id[p];
    for (int i = 0; i < N; i++) {
        
        if (id[i] == tmp || id[i]==id[q]) {
            id[i] = id[q];
        }
    }
//    cout << "Out Union" << endl;
    
}
void FindSum(int *id, int *weight, int N) {
//    cout << "In FindSum" << endl;
    
    std::map<long, long long> map;
//    cout << "The id is " << endl;
//    
//    for (int i = 0; i < N; i++) {
//        cout << i << " is " << id[i]<<endl;
//    }
    for (int i = 0; i < N; i++) {
        map[id[i]] = map[id[i]] + weight[i];
    }
    
    long long min = map[id[0]];
    typedef std::map<long, long long>::iterator it_type;
//    cout << "The ma is " << endl;
//    for (it_type iterator = map.begin(); iterator != map.end(); iterator++) {
//        cout << iterator->first << " ==>" << iterator->second << endl;
//    }
    
    for (it_type iterator = map.begin(); iterator != map.end(); iterator++) {
        if (iterator->second < min) {
            min = iterator->second;
        }
    }
    cout << min << endl;
}

int main() {
    
    int N, Q;
    std::cin >> N >> Q;
    int id[N];
    int weight[N];
    for (int i = 0; i < N; i++) {
        std::cin >> weight[i];
        id[i] = i;
    }
    int a, b;
    
    for (int i = 0; i < Q; i++) {
        std::cin >> a >> b;
        a--;
        b--;
//        cout << "You entered join " << a << " " << b << endl;
        Union(id, a, b, N);
        FindSum(id, weight, N);
    }
    
    return 0;
}

