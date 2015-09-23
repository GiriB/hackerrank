import math
list=[2]

def primelist(num):
    count = 3
    
    while count<num:
        isprime = True
        
        for x in range(2, int(math.sqrt(count) + 1)):
            if count % x == 0: 
                isprime = False
                break
        
        if isprime:
            list.append(count)
        
        count += 2



num=int(raw_input())
primelist(num)
print list
