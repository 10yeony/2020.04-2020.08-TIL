
import random

def makeLotto(num):
    for i in range(num):
        lottoList = []
        while len(set(lottoList))!=6:
            lottoList.append(random.randrange(1,46))
        print('게임', i+1, list(set(lottoList)))

def meanGrade(grade):
    total = 0;
    for g in grade:
        gradeToNum = {'A+':4.5, 'A':4.3, 'A-':4.0, 'B+':3.5, 'B':3.3, 'B-':3.0, 'C':2.5, 'D':1.5}
        total += gradeToNum[g]
    print('평균 : %.1f' %(total/len(grade)))
