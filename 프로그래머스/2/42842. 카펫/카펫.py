def solution(brown, yellow):
    answer = []
    
    w = 1
    h = 1
    count_brown = 0
    
    for i in range(1, yellow // 2 + 1):
        if yellow % i == 0:
            w = yellow // i
            h = i
            count_brown = w * 2 + h * 2 + 4

            if count_brown == brown:
                break
            
    return [w+2, h+2]