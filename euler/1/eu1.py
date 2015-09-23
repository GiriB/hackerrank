# Enter your code here. Read input from STDIN. Print output to STDOUT
T=int(raw_input())
def sum(s):
    s=int(s)
    return (s*(s+1))/2
while(T>0):
    N=int(raw_input())
    N-=1 #We need numbers below N
    print(sum(N/3)*3+sum(N/5)*5-sum(N/15)*15)
    T-=1