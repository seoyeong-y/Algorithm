def solution(routes):
    routes.sort(key=lambda x: x[1])
    
    # 마지막 카메라 위치 (-30,000 미만 값으로 초기화)
    camera = -30001
    check = 0
    
    for start, end in routes:
        if start > camera:
            camera = end
            check += 1
            
    return check