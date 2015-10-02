def getp(x):
    prime=-1
    length=0
    a=2
    while(True):
        # Loop through every number it could divide by
        for b in range(2, a):
            # Does b divide evenly into a ?
            if a % b == 0:
                break
        else:

            prime=(a)
            length+=1
        a+=1
        if length == x:
            return prime


T=int(raw_input())
while(T>0):

    N=int(raw_input())

    print getp(N)
    T-=1