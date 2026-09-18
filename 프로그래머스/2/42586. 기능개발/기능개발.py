def solution(progresses, speeds):
    days = []
    
    for (progress, speed) in zip(progresses, speeds):
        if (100 - progress) % speed == 0:
            n = (100 - progress) // speed
        else:
            n = (100 - progress) // speed + 1
        days.append(n)

    answer = [1]
    max_day = days[0]
    
    for i in range(1, len(days)):
        if days[i] <= max_day:
            answer[-1] += 1
        else:
            max_day = days[i]
            answer.append(1)
        
    return answer