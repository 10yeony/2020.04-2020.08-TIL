
def getSum(data):
    total = 0
    for d in data:
        total += d
    return total

def getMean(data):
    return getSum(data)/len(data)
    
def getMax(data):
    maxNum = data[0]
    for d in data[1:]: #data[0]은 비교할 필요 없음
        if maxNum < d:
            maxNum = d
    return maxNum
    
def getMin(data):
    minNum = int(data[0])
    for d in data[1:]:
        if minNum > d:
            minNum = d
    return minNum
    
    
def getTwoSum(num2, num1=1): #num1이 더 큰 값이 왔을 때...
    total = 0
    if num1 > num2:
        num1 ,num2 = num2, num1 #두 수를 스왑시킴
    for i in range(num1, num2+1):
        total += i
    return total
