from collections import deque

def solution(prices):
    answer = []
    queue = deque(prices)
    
    while queue:
        price = queue.popleft()
        time = 0
        
        for next_price in queue:
            time += 1
            if price > next_price:
                break
                
        answer.append(time)
        
    return answer