#-*- encoding: utf-8 -*-
print '中国'  
  
#字典的一键多值  
  
print'方案一 list作为dict的值 值允许重复'    
  
d1={}  
key=1  
value=2  
d1.setdefault(key,[]).append(value)  
value=2  
d1.setdefault(key,[]).append(value)  
  
print d1  
  
#获取值  
print '方案一 获取值'  
print list(d1[key])  
  
print '方案一 删除值，会留下一个空列表'  
d1[key].remove(value)  
d1[key].remove(value)  
print d1

 
numbers = [0,4,3,0,0]
i = range(5)
j = zip(numbers, i)
print j[1][0]

o=numbers.pop(0)
print numbers, o
