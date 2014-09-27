import time
import random

def quickSort(a, s, e):
    if s < e:
        mid = patition(a,s,e)
        quickSort(a, s, mid-1)
        quickSort(a, mid+1, e)
    return

def patition(a, s, e):
    key=a[e]
    i=s-1
    for j in xrange(s,e):  #j= frome s to e-1
        if a[j] < key:
            i=i+1
            a[i], a[j] = a[j], a[i]
    a[i+1], a[e]=a[e], a[i+1]
    return i+1

a=[]
for i in xrange(100):
    a.append(random.random()) 
tic = time.time()
quickSort(a, 0,len(a)-1)
toc = time.time()

for x in a[:]:
    print x
print 'runtime = ', toc-tic