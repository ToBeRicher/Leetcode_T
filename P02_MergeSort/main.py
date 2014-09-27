import time
import random

def mergeSort(a):
    if(len(a)<=1):
        return a
    mid = (len(a)) / 2
    left = mergeSort(a[:mid])
    right = mergeSort(a[mid:])
    return merge(left,right)

def merge(left, right):
    result=[]
    i,j=0,0  
    while i<len(left) and j<len(right):  
        if left[i]<=right[j]:  
            result.append(left[i])  
            i+=1  
        else:  
            result.append(right[j])  
            j+=1  
    result+=left[i:]  
    result+=right[j:]
    return result
    
a=[]
for i in xrange(1000):
    a.append(random.random()) 
tic = time.time()
a = mergeSort(a)
toc = time.time()

for x in a[:]:
    print x
print 'runtime = ', toc-tic