def solution(dots):
    answer = 0
    a = 0 
    b = 0
    
    for i in range (1,3):
        n1, m1 = [x for x in range(4) if x not in (0,i)]
        a = (dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]) 
        b = (dots[n1][1] - dots[m1][1]) / (dots[n1][0] - dots[m1][0]) 
        if a == b: 
            answer = 1
            break
            
    return answer